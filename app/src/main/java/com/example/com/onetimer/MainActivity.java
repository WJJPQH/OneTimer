package com.example.com.onetimer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTouxiang = (SimpleDraweeView) findViewById(R.id.touxiang);
        mTouxiang.setOnClickListener(this);
        mTitleName = (TextView) findViewById(R.id.title_name);
        mBianji = (ImageView) findViewById(R.id.bianji);
        mBianji.setOnClickListener(this);
        mFramlayout = (FrameLayout) findViewById(R.id.framlayout);
        mTuijian = (RadioButton) findViewById(R.id.tuijian);
        mTuijian.setOnClickListener(this);
        mDuanzi = (RadioButton) findViewById(R.id.duanzi);
        mDuanzi.setOnClickListener(this);
        mShipin = (RadioButton) findViewById(R.id.shipin);
        mShipin.setOnClickListener(this);
        mGroup = (RadioGroup) findViewById(R.id.group);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.touxiang:
                break;
            case R.id.bianji:
                break;
            case R.id.tuijian:
                break;
            case R.id.duanzi:
                break;
            case R.id.shipin:
                break;
        }
    }
}
