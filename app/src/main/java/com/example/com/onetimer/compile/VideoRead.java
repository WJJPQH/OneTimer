package com.example.com.onetimer.compile;

import java.io.File;

import com.example.com.onetimer.R;
import com.lidroid.xutils.http.RequestParams;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.http.RequestParams;

import java.io.File;

public class VideoRead extends Activity implements SurfaceHolder.Callback{

    /** Called when the activity is first created. */
    MediaPlayer player;
    SurfaceView surface;
    SurfaceHolder surfaceHolder;
    Button play,pause,stop,upload;
    String path = null;
    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view);
        play=(Button)findViewById(R.id.button1);
        pause=(Button)findViewById(R.id.button2);
        stop=(Button)findViewById(R.id.button3);
        upload = (Button)findViewById(R.id.button4);
        surface=(SurfaceView)findViewById(R.id.surface);

        surfaceHolder=surface.getHolder();   //SurfaceHolder是SurfaceView的控制接口
        surfaceHolder.addCallback(this);     //因为这个类实现了SurfaceHolder.Callback接口，所以回调参数直接this
        surfaceHolder.setFixedSize(320, 220);//显示的分辨率,不设置为视频默认
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);//Surface类型
        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                player.start();
            }});
        pause.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                player.pause();
            }});
        stop.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                player.stop();
            }});
        upload.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                //上传
                uploadFile();
            }});
    }

    @Override
    public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
    }
    //文件上传
    @SuppressLint("SdCardPath")
    public void uploadFile(){
        path = this.getIntent().getStringExtra("path");
        String userId = this.getIntent().getStringExtra("userId");
        String uploadHost = "http://192.168.1.103:808/sjdRtc/servlet/userUpload.do";
        String filePath = "/sdcard"+path.substring(path.lastIndexOf("/"));
        RequestParams params=new RequestParams();
        params.addBodyParameter("userId",userId);
        params.addBodyParameter(filePath.replace("/", ""), new File(filePath));
        UploadUtil load = new UploadUtil();
        load.uploadMethod(params, uploadHost);
    }

    @SuppressLint("SdCardPath")
    @Override
    public void surfaceCreated(SurfaceHolder arg0) {
//必须在surface创建后才能初始化MediaPlayer,否则不会显示图像
        player= new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        player.setDisplay(surfaceHolder);
        //设置显示视频显示在SurfaceView上
        try {
            // 新建Bundle对象
            path = this.getIntent().getStringExtra("path");
            player.setDataSource("/sdcard/im/video"+path.substring(path.lastIndexOf("/")));
            player.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder arg0) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(player.isPlaying()){
            player.stop();
        }
        player.release();
        //Activity销毁时停止播放，释放资源。不做这个操作，即使退出还是能听到视频播放的声音
    }

}
