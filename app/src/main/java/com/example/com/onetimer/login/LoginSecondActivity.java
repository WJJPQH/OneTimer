package com.example.com.onetimer.login;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.onetimer.MainActivity;
import com.example.com.onetimer.R;
import com.example.com.onetimer.base.BaseActivity;
import com.example.com.onetimer.bean.LoginBean;
import com.example.com.onetimer.component.DaggerHttpComponent;
import com.example.com.onetimer.reg.RegsActivity;
import com.example.com.onetimer.utils.SharedPreferencesUtils;
import com.facebook.drawee.view.SimpleDraweeView;

public class LoginSecondActivity extends BaseActivity<LoginPresenter> implements View.OnClickListener,LoginContract.View {

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
        initView();
    }
    @Override
    public int getContentLayout() {
        return R.layout.activity_login_second;
    }
    public void initView(){
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
                String mobiles = username.getText().toString();
                String passwords = password.getText().toString();
                mPresenter.getLogin(mobiles, passwords);
                Intent intent3 = new Intent(LoginSecondActivity.this, MainActivity.class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent3);
                LoginSecondActivity.this.finish();
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



    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Toast.makeText(LoginSecondActivity.this,loginBean.getMsg(),Toast.LENGTH_LONG).show();
        SharedPreferencesUtils.setParam(LoginSecondActivity.this,"uid",loginBean.getData().getUid() + "");
        SharedPreferencesUtils.setParam(LoginSecondActivity.this,"mobile",loginBean.getData().getMobile() + "");
        SharedPreferencesUtils.setParam(LoginSecondActivity.this,"icon",loginBean.getData().getIcon() + "");
        SharedPreferencesUtils.setParam(LoginSecondActivity.this,"token",loginBean.getData().getToken() + "");

    }
}
