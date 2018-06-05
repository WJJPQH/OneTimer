package com.example.com.onetimer.login;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.onetimer.R;
import com.example.com.onetimer.base.BaseActivity;
import com.facebook.drawee.view.SimpleDraweeView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView simpleimg;
    private TextView logintxt;
    private ImageView imgback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        simpleimg = findViewById(R.id.simpleimg);
        logintxt = findViewById(R.id.logintxt);
        imgback = findViewById(R.id.back);
        imgback.setOnClickListener(this);
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
        }
    }
}
