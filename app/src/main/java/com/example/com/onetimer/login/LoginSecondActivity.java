package com.example.com.onetimer.login;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.onetimer.MainActivity;
import com.example.com.onetimer.R;
import com.example.com.onetimer.reg.RegsActivity;
import com.facebook.drawee.view.SimpleDraweeView;

public class LoginSecondActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back;
    private TextView regtxt;
    private EditText username;
    private EditText password;
    private TextView forget;
    private SimpleDraweeView simpleimg;
    private TextView yoke;
    private Button loginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_second);
        back = findViewById(R.id.back);
        back.setOnClickListener(this);
        regtxt = findViewById(R.id.regtxt);
        regtxt.setOnClickListener(this);
        username = findViewById(R.id.user_name);
        username.setOnClickListener(this);
        password = findViewById(R.id.password);
        password.setOnClickListener(this);
        forget = findViewById(R.id.forget);
        forget.setOnClickListener(this);
        yoke = findViewById(R.id.yoke);
        yoke.setOnClickListener(this);
        loginbtn = findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(this);
        simpleimg = findViewById(R.id.simpleimg);
        simpleimg.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.login)).build());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                LoginSecondActivity.this.finish();
                break;
            case R.id.regtxt:
                Intent intent = new Intent(LoginSecondActivity.this, RegsActivity.class);
                startActivity(intent);
                break;
            case R.id.forget:
                break;
            case R.id.loginbtn:
                break;
            case R.id.yoke:
                Intent intent2 = new Intent(LoginSecondActivity.this, MainActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent2);
                LoginSecondActivity.this.finish();
                break;
                default:
                    break;
        }
    }
}
