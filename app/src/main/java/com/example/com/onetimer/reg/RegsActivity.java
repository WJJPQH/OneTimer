package com.example.com.onetimer.reg;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.onetimer.MainActivity;
import com.example.com.onetimer.R;
import com.example.com.onetimer.base.BaseActivity;
import com.example.com.onetimer.bean.RegisterBean;
import com.example.com.onetimer.component.DaggerHttpComponent;
import com.example.com.onetimer.login.LoginActivity;
import com.example.com.onetimer.login.LoginSecondActivity;
import com.facebook.drawee.view.SimpleDraweeView;

public class RegsActivity extends BaseActivity<RegisterPresenter> implements View.OnClickListener,RegisterContract.View {
    private ImageView back;
    private TextView oktxt;
    private EditText mobile;
    private EditText password;
    private Button regbtn;
    private TextView yoke;
    private SimpleDraweeView simpleimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }
    public void initView(){
        back = findViewById(R.id.back);
        back.setOnClickListener(this);
        oktxt = findViewById(R.id.oktxt);
        oktxt.setOnClickListener(this);
        mobile = findViewById(R.id.mobile);
        password = findViewById(R.id.password);
        regbtn = findViewById(R.id.regbtn);
        regbtn.setOnClickListener(this);
        yoke = findViewById(R.id.yoke);
        yoke.setOnClickListener(this);
        simpleimg = findViewById(R.id.simpleimg);
        simpleimg.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.login)).build());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                RegsActivity.this.finish();
                break;
            case R.id.oktxt:
                RegsActivity.this.finish();
                break;
            case R.id.regbtn:
                String mobiles = mobile.getText().toString();
                String passwords = password.getText().toString();
                mPresenter.getRegister(mobiles, passwords);
                RegsActivity.this.finish();
                break;
            case R.id.yoke:
                Intent intent2 = new Intent(RegsActivity.this, MainActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent2);
                RegsActivity.this.finish();
                break;
            default:
                break;
        }

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_regs;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void onRegSuccess(RegisterBean registerBean) {
        Toast.makeText(RegsActivity.this, registerBean.getMsg(), Toast.LENGTH_SHORT).show();
    }
}
