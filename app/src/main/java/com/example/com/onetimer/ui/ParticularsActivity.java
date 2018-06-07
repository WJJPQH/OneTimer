package com.example.com.onetimer.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.com.onetimer.R;
import com.example.com.onetimer.adapter.UserVideosBean;
import com.example.com.onetimer.adapter.UserVoidersAdapter;
import com.example.com.onetimer.base.BaseActivity;
import com.example.com.onetimer.bean.RecommendBean;
import com.example.com.onetimer.component.DaggerHttpComponent;
import com.example.com.onetimer.recommend.contract.UserVideosContract;
import com.example.com.onetimer.recommend.persenter.UserVideosPersenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ParticularsActivity extends BaseActivity<UserVideosPersenter> implements View.OnClickListener,UserVideosContract.View {

    private Serializable bean;
    private int posion;
    private RecommendBean.DataBean list;
    private ImageView mBjt;
    private ImageView mParticularsFh;
    /**
     * MC 跨足令
     */
    private TextView mParticularsTitleName;
    private ImageView mParticularsShare;
    private SimpleDraweeView mParticularsTitleTx;
    /**
     * 18595447 粉丝
     */
    private TextView mFs;
    /**
     * 17 粉丝
     */
    private TextView mUserGz;
    /**
     * +关注
     */
    private Button mButGz;
    /**
     * 作品(3)
     */
    private TextView mParticularsZp;
    private ImageView mDdz;
    /**
     * 16
     */
    private TextView mDzNum;
    private RelativeLayout mDz;
    private boolean isRefresh = true;
    private LinearLayout mHt;
    private XRecyclerView mParticularsRlv;
    private int uid;
    private int num;
    private List<UserVideosBean.DataBean> templist;
    private List<UserVideosBean.DataBean> allList=new ArrayList<>();
    private UserVoidersAdapter userVoidesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        Intent intent = getIntent();
        //接收用户的信息
        list = (RecommendBean.DataBean) intent.getSerializableExtra("mylist");
        mParticularsTitleTx.setImageURI(list.getUser().getIcon());
        mParticularsTitleName.setText(list.getUser().getNickname());
        mUserGz.setText(list.getFavoriteNum()+" 关注");
        uid = list.getUid();
        mDzNum.setText(list.getPraiseNum()+"");
        mFs.setText(list.getFavoriteNum()+" 粉丝");
        //请求作品列表
        mPresenter.getUserVoides(""+uid,""+num);
        //设置布局管理器
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1,RecyclerView.VERTICAL,false);
        mParticularsRlv.setLayoutManager(gridLayoutManager);
        mParticularsRlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //刷新
                isRefresh=true;
                num=1;
                mPresenter.getUserVoides(""+uid,""+num);
            }

            @Override
            public void onLoadMore() {
                //加载更多
                isRefresh=false;
                num+=1;
                mPresenter.getUserVoides(""+uid,""+num);
            }
        });
    }

    private void initView() {
        mBjt = (ImageView) findViewById(R.id.bjt);
        mParticularsFh = (ImageView) findViewById(R.id.particulars_fh);
        mParticularsTitleName = (TextView) findViewById(R.id.particulars_title_name);
        mParticularsShare = (ImageView) findViewById(R.id.particulars_share);
        mParticularsTitleTx = (SimpleDraweeView) findViewById(R.id.particulars_title_tx);
        mFs = (TextView) findViewById(R.id.fs);
        mFs.setOnClickListener(this);
        mUserGz = (TextView) findViewById(R.id.user_gz);
        mButGz = (Button) findViewById(R.id.but_gz);
        mButGz.setOnClickListener(this);
        mParticularsZp = (TextView) findViewById(R.id.particulars_zp);
        mDdz = (ImageView) findViewById(R.id.ddz);
        mDzNum = (TextView) findViewById(R.id.dz_num);
        mDz = (RelativeLayout) findViewById(R.id.dz);
        mDz.setOnClickListener(this);
        mHt = (LinearLayout) findViewById(R.id.ht);
        mParticularsRlv = (XRecyclerView) findViewById(R.id.particulars_rlv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fs:
                finish();
                break;
            case R.id.but_gz:
                break;
            case R.id.dz:
                break;
        }
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_particulars;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void UserVoidesSuccess(UserVideosBean userVideosBean) {
            templist=userVideosBean.getData();
            allList.addAll(templist);
        userVoidesAdapter=new UserVoidersAdapter(list,ParticularsActivity.this,templist);
        setadapter();
    }
    private void setadapter() {
        if(isRefresh){
            userVoidesAdapter=new UserVoidersAdapter(list,ParticularsActivity.this,templist);
            mParticularsRlv.setAdapter(userVoidesAdapter);
            userVoidesAdapter.refresh(allList);
            mParticularsRlv.refreshComplete();//设置刷新完成
        }else{
            if(userVoidesAdapter!=null){
                userVoidesAdapter.loadMore(allList);
                mParticularsRlv.loadMoreComplete();//设置加载更多完成
            }
        }
        if (userVoidesAdapter==null){
            return;
        }

    }
}
