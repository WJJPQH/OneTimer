package com.example.com.onetimer;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.onetimer.attention.AttentionActivity;
import com.example.com.onetimer.compile.CompileActivity;
import com.example.com.onetimer.duanzi.CrossFragment;
import com.example.com.onetimer.login.LoginActivity;
import com.example.com.onetimer.login.LoginSecondActivity;
import com.example.com.onetimer.recommend.fragment.Fragment_recommend;
import com.example.com.onetimer.utils.SharedPreferencesUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SimpleDraweeView mTouxiang;
    /**
     * 推荐
     */
    private DrawerLayout drawerLayout;
    private TextView mTitleName;
    private ImageView mBianji;
    private FrameLayout mFramlayout;
    private RadioButton mTuijian;
    private RadioButton mDuanzi;
    private RadioButton mShipin;
    private RadioGroup mGroup;
    private NavigationView navigationView;
    private FragmentManager fragmentManager;
    private CrossFragment crossFragment;
    private List<String> list;
    private SimpleDraweeView person;
    private TextView user_name;
    private Fragment_recommend remmendFragment;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        initView();
        crossFragment = new CrossFragment();
        remmendFragment=new Fragment_recommend();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.framlayout,remmendFragment).commit();
        setListener();
        initWindow();
    }
    private void initWindow() {//初始化窗口属性，让状态栏和导航栏透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            int statusColor = Color.parseColor("#1976d2");
        }
    }
    private void initView() {
        drawerLayout = findViewById(R.id.draw);
        mTouxiang = (SimpleDraweeView) findViewById(R.id.touxiang);
        mTouxiang.setOnClickListener(this);
        mTouxiang.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.touxiang)).build());
        mTitleName = (TextView) findViewById(R.id.title_name);
        mBianji = (ImageView) findViewById(R.id.bianji);
        mBianji.setOnClickListener(this);
        mFramlayout = (FrameLayout) findViewById(R.id.framlayout);
        mTuijian = (RadioButton) findViewById(R.id.tuijian);
        mDuanzi = (RadioButton) findViewById(R.id.duanzi);
        mShipin = (RadioButton) findViewById(R.id.shipin);
        mGroup = (RadioGroup) findViewById(R.id.group);
        navigationView = findViewById(R.id.nav);
        View headerView = navigationView.getHeaderView(0);
        person  = headerView.findViewById(R.id.person);
        user_name = headerView.findViewById(R.id.yoname);
        user_name.setText("我爱");
        person.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.touxiang)).build());
        person.setOnClickListener(this);
        uid = (String) SharedPreferencesUtils.getParam(MainActivity.this, "uid", "");
        if (!TextUtils.isEmpty(uid)) {
            String mobile = (String) SharedPreferencesUtils.getParam(MainActivity.this, "mobile", "");
            String icon = (String) SharedPreferencesUtils.getParam(MainActivity.this,"icon","");
            user_name.setText(mobile);
//            Glide.with(MainActivity.this).load(icon).into(person);
            person.setImageURI(icon);

        }else {
            String name = (String) SharedPreferencesUtils.getParam(MainActivity.this, "name", "");
            user_name.setText(name);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                if(item.getItemId()==R.id.wallet){
                    uid = (String) SharedPreferencesUtils.getParam(MainActivity.this, "uid", "");
                    if(uid.equals("")){
                        new AlertDialog.Builder(MainActivity.this).setTitle("抱歉您还没有登录!")
                                .setPositiveButton("立即登录", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent=new Intent(MainActivity.this, LoginSecondActivity.class);
                                        startActivity(intent);
                                    }
                                }).setNegativeButton("取消", null).show();

                    }else{
                        Intent intent =new Intent(MainActivity.this, AttentionActivity.class);
                        startActivity(intent);
                    }

                }
                drawerLayout.closeDrawer(navigationView);
                return true;
            }
        });
    }

    public void setListener(){
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.tuijian:
                        mTitleName.setText("推荐");
                        fragmentManager.beginTransaction().replace(R.id.framlayout,remmendFragment).commit();
                        break;
                    case R.id.duanzi:
                        mTitleName.setText("段子");
                        fragmentManager.beginTransaction().replace(R.id.framlayout,crossFragment).commit();
                        Toast.makeText(MainActivity.this,"点击",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.shipin:
                        break;
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            default:
                break;
            case R.id.touxiang:
                if (drawerLayout.isDrawerOpen(navigationView)){
                    drawerLayout.closeDrawer(navigationView);
                }else{
                    drawerLayout.openDrawer(navigationView);
                }
                break;
            case R.id.bianji:
                Intent intent2 = new Intent(MainActivity.this, CompileActivity.class);
                startActivity(intent2);
                break;
            case R.id.person:
                uid = (String) SharedPreferencesUtils.getParam(MainActivity.this, "uid", "");
                if (!TextUtils.isEmpty(uid)) {
                    //登录过
                  Toast.makeText(MainActivity.this,"登录过了",Toast.LENGTH_SHORT).show();
                } else {
                    //未登录
                    Intent intent  =new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

                break;
        }
    }
}
