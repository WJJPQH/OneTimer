package com.example.com.onetimer.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.com.onetimer.MainActivity;
import com.example.com.onetimer.R;
import com.example.com.onetimer.adapter.MyAttentionAdapter;
import com.example.com.onetimer.adapter.UserVoidersAdapter2;
import com.example.com.onetimer.attention.AttentionActivity;
import com.example.com.onetimer.base.AttentionUserBean;
import com.example.com.onetimer.bean.AttentionBean;
import com.example.com.onetimer.bean.UserVideosBean;
import com.example.com.onetimer.adapter.UserVoidersAdapter;
import com.example.com.onetimer.base.BaseActivity;
import com.example.com.onetimer.bean.RecommendBean;
import com.example.com.onetimer.component.DaggerHttpComponent;
import com.example.com.onetimer.login.LoginSecondActivity;
import com.example.com.onetimer.recommend.contract.UserVideosContract;
import com.example.com.onetimer.recommend.persenter.UserVideosPersenter;
import com.example.com.onetimer.utils.SharedPreferencesUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ParticularsActivity extends BaseActivity<UserVideosPersenter> implements View.OnClickListener,UserVideosContract.View {

    private Serializable bean;
    private int posion;
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
    private LinearLayout mHt;
    private XRecyclerView mParticularsRlv;
    private int uid;
    private int num;
    private List<UserVideosBean.DataBean> templist;
    private List<UserVideosBean.DataBean> allList=new ArrayList<>();
    private UserVoidersAdapter userVoidesAdapter;
    private boolean gz_pd=false;
    private int dz_num;
    private int dz_pd=3;
    private boolean isRefresh=true;
    private String wid;
    private boolean pd_gz=true;
    private int userwid;
    private String token;
    private int sb;
    private RecommendBean.DataBean list1;
    private AttentionBean.DataBean list2;
    private UserVoidersAdapter2 userVoidesAdapter2;
    private String dz_num1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        Intent intent = getIntent();
        sb = intent.getIntExtra("sb", 0);

        if (sb == 1) {
            //接收用户的信息
            list1 = (RecommendBean.DataBean) intent.getSerializableExtra("mylist");
            mParticularsTitleTx.setImageURI(list1.getUser().getIcon());
            mParticularsTitleName.setText(list1.getUser().getNickname());
            mUserGz.setText(list1.getFavoriteNum() + " 关注");
            uid = list1.getUid();
            mDzNum.setText(list1.getPraiseNum() + "");
            dz_num = list1.getPraiseNum();
            mFs.setText(list1.getFavoriteNum() + " 粉丝");
            uid = list1.getUid();
            userwid = list1.getWid();
        } else {
            list2 = (AttentionBean.DataBean) intent.getSerializableExtra("mylist");
            mParticularsTitleTx.setImageURI(list2.getIcon());
            mParticularsTitleName.setText(list2.getNickname() + "");
            mUserGz.setText(list2.getFollow() + " 关注");
            uid = list2.getUid();
            mDzNum.setText(list2.getPraiseNum() + "");
            dz_num1 = (String) list2.getPraiseNum();
            mFs.setText(list2.getFans() + " 粉丝");
            uid = list2.getUid();
            userwid = 0;
        }
        wid = (String) SharedPreferencesUtils.getParam(this, "uid", "");
        token = (String) SharedPreferencesUtils.getParam(this, "token", "");
        //请求作品列表
        mPresenter.getUserVoides("" + uid, "" + num);


    }

    private void initView() {
        mBjt = (ImageView) findViewById(R.id.bjt);
        mParticularsFh = (ImageView) findViewById(R.id.particulars_fh);
        mParticularsFh.setOnClickListener(this);
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
        mParticularsRlv = (XRecyclerView) findViewById(R.id.particulars_framenlayout);
        //设置布局管理器
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1, RecyclerView.VERTICAL,false);
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
                isRefresh=true;
                num++;
                mPresenter.getUserVoides(""+uid,""+num);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.particulars_fh:
                finish();
                break;
            case R.id.but_gz:
                        if(gz_pd){
                            mButGz.setText("+关注");
                            mButGz.setBackgroundColor(Color.WHITE);
                            gz_pd=false;
                            Toast.makeText(ParticularsActivity.this,"已取消关注!",Toast.LENGTH_SHORT).show();
                        }else{
                            mButGz.setText("已关注");
                            mButGz.setBackgroundColor(getResources().getColor(R.color.two));
                            gz_pd=true;
                            if(wid.equals("")){
                                new AlertDialog.Builder(this).setTitle("抱歉您还没有登录!")
                                        .setPositiveButton("立即登录", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Intent intent=new Intent(ParticularsActivity.this, LoginSecondActivity.class);
                                               startActivity(intent);
                                            }
                                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent=new Intent(ParticularsActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                }).show();
                            }else{
                               if(userwid==0){
                                   Toast.makeText(ParticularsActivity.this,"已经关注过了!",Toast.LENGTH_SHORT).show();
                               }
                               else{
                                   mPresenter.getAttentionUser(""+wid,""+userwid,""+token);
                               }
                            }
                        }
                break;
            case R.id.dz:
                    if(dz_pd==3){
                        dz_num++;
                        mDz.setBackground(getResources().getDrawable(R.drawable.dianzan_one));
                        if(sb==1){
                            mDzNum.setText(""+dz_num);
                        }else{
                            mDzNum.setText(""+dz_num1);
                        }
                        dz_pd--;
                    }else if(dz_pd==2){
                        dz_num++;
                        mDz.setBackground(getResources().getDrawable(R.drawable.dianzan_two));
                        if(sb==1){
                            mDzNum.setText(""+dz_num);
                        }else{
                            mDzNum.setText(""+dz_num1);
                        }
                        dz_pd--;
                    }else if(dz_pd==1){
                        dz_num++;
                        mDz.setBackground(getResources().getDrawable(R.drawable.dianzan_there));
                        if(sb==1){
                            mDzNum.setText(""+dz_num);
                        }else{
                            mDzNum.setText(""+dz_num1);
                        }
                        mDz.setEnabled(false);
                    }
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
            if(sb==1){
                userVoidesAdapter=new UserVoidersAdapter(list1,ParticularsActivity.this,templist);
            }else{
                userVoidesAdapter2=new UserVoidersAdapter2(list2,ParticularsActivity.this,templist);
            }
            setadapter();
    }

    @Override
    public void AttentionSuccess(AttentionUserBean attentionUserBean) {
        Toast.makeText(ParticularsActivity.this,""+attentionUserBean.getMsg(),Toast.LENGTH_SHORT).show();
    }

    private void setadapter() {
        if(isRefresh){
            if(sb==1){
                userVoidesAdapter=new UserVoidersAdapter(list1,ParticularsActivity.this,templist);
                mParticularsRlv.setAdapter(userVoidesAdapter);
                userVoidesAdapter.refresh(allList);
                mParticularsRlv.refreshComplete();//设置刷新完成
            }else if(sb==2){
                userVoidesAdapter2=new UserVoidersAdapter2(list2,ParticularsActivity.this,templist);
                mParticularsRlv.setAdapter(userVoidesAdapter2);
                userVoidesAdapter2.refresh(allList);
                mParticularsRlv.refreshComplete();//设置刷新完成
            }
        }else{
            if(userVoidesAdapter!=null){
               if(sb==1){
                   userVoidesAdapter.loadMore(allList);
               }else if(sb==2){
                   userVoidesAdapter2.loadMore(allList);
               }
                mParticularsRlv.loadMoreComplete();//设置加载更多完成
            }
        }
        if (userVoidesAdapter==null){
            return;
        }
    }
}
