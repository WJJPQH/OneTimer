
package com.example.com.onetimer.video;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.com.onetimer.R;
import com.example.com.onetimer.bean.HotVideosBean;
import com.example.com.onetimer.bean.NearVideosBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.debug.log.E;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class XiangActivity extends AppCompatActivity implements View.OnClickListener {
    private HotVideosBean.DataBean bean;
    private NearVideosBean.DataBean dataBean;
    private SimpleDraweeView video_user;
    private JCVideoPlayerStandard video_video;
    private TextView work_desc;
    private TextView he;
    private ImageView back_img;
    private ImageView like;
    private ImageView unlike;
    private boolean like_pd = true;
    private boolean unlike_pd = true;
    private  int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_xiang);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        Intent intent = getIntent();
        flag = intent.getIntExtra("flag",-1);
        if (flag==HotVideoFragment.HOTVIDEO){
            bean = (HotVideosBean.DataBean) intent.getSerializableExtra("bean");
        }else {
            dataBean = (NearVideosBean.DataBean) intent.getSerializableExtra("bean");
        }

        initView();
    }

    private void initView() {
        video_user = findViewById(R.id.video_user);

        video_video = findViewById(R.id.video_video);

        work_desc = findViewById(R.id.work_desc);

        he = findViewById(R.id.he);

        if (flag==HotVideoFragment.HOTVIDEO){
            Glide.with(this).load(bean.getUser().getIcon()).into(video_user);
            video_video.TOOL_BAR_EXIST = false;
            video_video.setUp(bean.getVideoUrl()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "看什么没有标题啦!");
            Glide.with(this).load(bean.getCover())
                    .into( video_video.thumbImageView);
            work_desc.setText(bean.getWorkDesc());
            he.setText(bean.getCreateTime());
        }else {
            Glide.with(this).load(dataBean.getUser().getIcon()).into(video_user);
            video_video.TOOL_BAR_EXIST = false;
            video_video.setUp(dataBean.getVideoUrl()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "看什么没有标题啦!");
            Glide.with(this).load(dataBean.getCover())
                    .into( video_video.thumbImageView);
            work_desc.setText(dataBean.getWorkDesc());
            he.setText(dataBean.getCreateTime());
        }
        back_img = findViewById(R.id.back_img);
        back_img.setOnClickListener(this);
        like = findViewById(R.id.like);
        like.setOnClickListener(this);
        unlike = findViewById(R.id.unlike);
        unlike.setOnClickListener(this);
        Glide.with(this).load(R.drawable.raw_1499933216).into(like);
        Glide.with(this).load(R.drawable.raw_1499933217).into(unlike);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_img:
                finish();
                break;
            case R.id.like:
                if(like_pd==true){
                    Toast.makeText(XiangActivity.this,"喜欢",Toast.LENGTH_SHORT).show();

                    like_pd=false;
                    Glide.with(this).load(R.drawable.raw_1500090533).into(like);
                }else {
                    like_pd=true;
                    Toast.makeText(XiangActivity.this,"不喜欢",Toast.LENGTH_SHORT).show();

                    Glide.with(this).load(R.drawable.raw_1499933216).into(like);

                }
                break;
            case R.id.unlike:
                if(unlike_pd==true){
                    Toast.makeText(XiangActivity.this,"讨厌",Toast.LENGTH_SHORT).show();
                    like_pd=false;
                    Glide.with(this).load(R.drawable.raw_1500257333).into(unlike);
                }else {
                    like_pd=true;
                    Toast.makeText(XiangActivity.this,"不讨厌",Toast.LENGTH_SHORT).show();
                    Glide.with(this).load(R.drawable.raw_1499933217).into(unlike);
                }
                break;
        }
    }
}
