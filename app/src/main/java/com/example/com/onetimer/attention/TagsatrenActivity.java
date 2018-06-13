package com.example.com.onetimer.attention;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.com.onetimer.R;

import java.util.ArrayList;
import java.util.List;

public class TagsatrenActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 取消
     */
    private TextView mRmgzFh;
    /**
     * 输入关键字
     */
    private EditText mRmgzEdt;
    private ImageView mRmgzSs;
    private TabLayout mMytab;
    private ViewPager mVp;
    private List<String> lists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tagsatren);
        initView();
        initData();
        //设置适配器
        mVp.setAdapter(new MyAdapter(getSupportFragmentManager()));
        //将tablayout组件与viewPager组件进行关联
        mMytab.setupWithViewPager(mVp);
        mMytab.getTabAt(3).select();
    }

    private void initView() {
        mRmgzFh = (TextView) findViewById(R.id.rmgz_fh);
        mRmgzFh.setOnClickListener(this);
        mRmgzEdt = (EditText) findViewById(R.id.rmgz_edt);
        mRmgzSs = (ImageView) findViewById(R.id.rmgz_ss);
        mRmgzSs.setOnClickListener(this);
        mMytab = (TabLayout) findViewById(R.id.mytab);
        mMytab.setOnClickListener(this);
        mVp = (ViewPager) findViewById(R.id.vp);
        mVp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rmgz_fh://取消
                finish();
                break;
            case R.id.rmgz_ss:
                break;
            case R.id.mytab:
                break;
            case R.id.vp:
                break;
        }
    }
    private void initData() {
        lists=new ArrayList<>();
        lists.add("新闻");
        lists.add("爆笑");
        lists.add("励志");
        lists.add("美食");
        lists.add("网红");
        lists.add("颜值");
    }


    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }


        //返回页面的标题--tabLayout的标签
        @Override
        public CharSequence getPageTitle(int position) {
            return lists.get(position);
        }


        @Override
        public Fragment getItem(int position) {
            Popularattention popularattention =new Popularattention();

            return popularattention;
        }


        @Override
        public int getCount() {
            return lists.size();
        }
    }
}
