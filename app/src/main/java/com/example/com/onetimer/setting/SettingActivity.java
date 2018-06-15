package com.example.com.onetimer.setting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TimeUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.onetimer.MainActivity;
import com.example.com.onetimer.R;
import com.example.com.onetimer.login.LoginActivity;
import com.example.com.onetimer.utils.SharedPreferencesUtils;

public class SettingActivity extends AppCompatActivity {

    private Button btn_exit;
    private String uid;
    private TextView back_i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        btn_exit = findViewById(R.id.btn_exit);
        back_i = findViewById(R.id.back_i);
        back_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uid = (String) SharedPreferencesUtils.getParam(SettingActivity.this, "uid", "");
                if (!TextUtils.isEmpty(uid)){
                    SharedPreferencesUtils.clear(SettingActivity.this);
                    //回到登录页面
                    Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    SettingActivity.this.finish();
                }else {
                    Toast.makeText(SettingActivity.this,"还没登录哦",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
