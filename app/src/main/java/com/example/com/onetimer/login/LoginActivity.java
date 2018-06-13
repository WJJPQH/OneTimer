package com.example.com.onetimer.login;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.onetimer.R;
import com.example.com.onetimer.base.BaseActivity;
import com.example.com.onetimer.net.LoginApi;
import com.example.com.onetimer.utils.SharedPreferencesUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView simpleimg;
    private TextView logintxt;
    private ImageView imgback;
    private ImageView imglogin;
    private String name;
    private String iconurl;
    private String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        simpleimg = findViewById(R.id.simpleimg);
        logintxt = findViewById(R.id.logintxt);
        imgback = findViewById(R.id.back);
        imgback.setOnClickListener(this);
        imglogin =findViewById(R.id.qqlogin);
        imglogin.setOnClickListener(this);
        simpleimg.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.login)).build());
        logintxt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            default:
                break;
            case R.id.logintxt:
                Intent intent = new Intent(LoginActivity.this,LoginSecondActivity.class);
                startActivity(intent);
                break;
            case R.id.back:
                finish();
                break;
            case R.id.qqlogin:
                UMShareAPI mShareAPI = UMShareAPI.get(LoginActivity.this);
                mShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                finish();
                break;
        }
    }
    UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            Log.e("onStart", "onStart");
        }

        //授权成功了。map里面就封装了一些qq信息
        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            SharedPreferencesUtils.setParam(LoginActivity.this,"uid",uid + "");
            SharedPreferencesUtils.setParam(LoginActivity.this,"name", name+ "");
            SharedPreferencesUtils.setParam(LoginActivity.this,"iconurl",iconurl + "");
            uid = map.get("uid");
            String openid = map.get("openid");//微博没有
            String unionid = map.get("unionid");//微博没有
            String access_token = map.get("access_token");
            String refresh_token = map.get("refresh_token");//微信,qq,微博都没有获取到
            String expires_in = map.get("expires_in");
            name = map.get("name");
            String gender = map.get("gender");//性别
            iconurl = map.get("iconurl");//头像
            Toast.makeText(getApplicationContext(), "name=" + name + ",gender=" + gender, Toast.LENGTH_SHORT).show();
        }

        //授权失败
        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            Log.e("onError", "onError");
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            Log.e("onCancel", "onCancel");
        }

    };
    //授权回调
    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }
}
