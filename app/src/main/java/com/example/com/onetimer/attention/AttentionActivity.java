package com.example.com.onetimer.attention;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.com.onetimer.MainActivity;
import com.example.com.onetimer.R;
import com.example.com.onetimer.adapter.MyAttentionAdapter;
import com.example.com.onetimer.adapter.UserVoidersAdapter;
import com.example.com.onetimer.base.BaseActivity;
import com.example.com.onetimer.base.BaseFragment;
import com.example.com.onetimer.bean.AttentionBean;
import com.example.com.onetimer.component.DaggerHttpComponent;
import com.example.com.onetimer.login.LoginSecondActivity;
import com.example.com.onetimer.recommend.contract.AttentionContract;
import com.example.com.onetimer.recommend.persenter.AttentionPersenter;
import com.example.com.onetimer.ui.ParticularsActivity;
import com.example.com.onetimer.utils.SharedPreferencesUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class AttentionActivity extends BaseActivity<AttentionPersenter> implements AttentionContract.View  {

    private String uid;
    private String token;
    private List<AttentionBean.DataBean> list;
    private RecyclerView rlv;
    private boolean isRefresh = true;
    private MyAttentionAdapter userVoidesAdapter;
    private TextView fh;
    private TextView attention;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //获取uid
        uid = (String) SharedPreferencesUtils.getParam(this, "uid", "");
        token = (String) SharedPreferencesUtils.getParam(this, "token", "");
        mPresenter.getAttention(uid,token);
        rlv=findViewById(R.id.myattention_rlv);
        attention=findViewById(R.id.tagsattention);
        fh=findViewById(R.id.attention_fh);
        //设置布局管理器
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1,RecyclerView.VERTICAL,false);
        rlv.setLayoutManager(gridLayoutManager);
        fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        attention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AttentionActivity.this,TagsatrenActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_attention;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void AttentionSuccess(AttentionBean attentionBean) {
        list=attentionBean.getData();
        userVoidesAdapter=new MyAttentionAdapter(list,AttentionActivity.this);
        rlv.setAdapter(userVoidesAdapter);
    }

}
