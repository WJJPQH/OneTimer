package com.example.com.onetimer;
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

import com.example.com.onetimer.cehua.AttentionActivity;
import com.example.com.onetimer.duanzi.CrossFragment;
import com.example.com.onetimer.login.LoginActivity;
import com.example.com.onetimer.recommend.fragment.Fragment_recommend;
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
    private Fragment_recommend remmendFragment;

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
        mFramlayout = (FrameLayout) findViewById(R.id.framlayout);
        mTuijian = (RadioButton) findViewById(R.id.tuijian);
        mDuanzi = (RadioButton) findViewById(R.id.duanzi);
        mShipin = (RadioButton) findViewById(R.id.shipin);
        mGroup = (RadioGroup) findViewById(R.id.group);
        navigationView = findViewById(R.id.nav);
        View headerView = navigationView.getHeaderView(0);
        person  = headerView.findViewById(R.id.person);
//        Glide.with(this).load(R.drawable.touxiang).into(person);
        person.setImageURI((new Uri.Builder()).scheme("res").path(String.valueOf(R.drawable.touxiang)).build());
        person.setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                if(item.getItemId()==R.id.wallet){
                    Intent intent =new Intent(MainActivity.this, AttentionActivity.class);
                    startActivity(intent);
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
            case R.id.person:
                Intent intent  =new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
