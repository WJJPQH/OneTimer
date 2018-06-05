package com.example.com.onetimer;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.onetimer.duanzi.CrossFragment;
import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView mTouxiang;
    /**
     * 推荐
     */
    private TextView mTitleName;
    private ImageView mBianji;
    private FrameLayout mFramlayout;
    private RadioButton mTuijian;
    private RadioButton mDuanzi;
    private RadioButton mShipin;
    private RadioGroup mGroup;
    private FragmentManager fragmentManager;
    private CrossFragment crossFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        crossFragment = new CrossFragment();
        fragmentManager = getSupportFragmentManager();
        setListener();

    }

    private void initView() {
        mTouxiang = (SimpleDraweeView) findViewById(R.id.touxiang);
        mTitleName = (TextView) findViewById(R.id.title_name);
        mBianji = (ImageView) findViewById(R.id.bianji);
        mFramlayout = (FrameLayout) findViewById(R.id.framlayout);
        mTuijian = (RadioButton) findViewById(R.id.tuijian);
        mDuanzi = (RadioButton) findViewById(R.id.duanzi);
        mShipin = (RadioButton) findViewById(R.id.shipin);
        mGroup = (RadioGroup) findViewById(R.id.group);

    }

    public void setListener(){
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.tuijian:
                        break;
                    case R.id.duanzi:
                        fragmentManager.beginTransaction().replace(R.id.framlayout,crossFragment).commit();
                        Toast.makeText(MainActivity.this,"点击",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.shipin:
                        break;
                }
            }
        });
    }
}
