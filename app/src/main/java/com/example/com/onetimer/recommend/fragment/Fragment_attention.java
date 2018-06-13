package com.example.com.onetimer.recommend.fragment;

import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;

import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.com.onetimer.MainActivity;
import com.example.com.onetimer.R;
import com.example.com.onetimer.adapter.AttentionAdapter;
import com.example.com.onetimer.base.BaseFragment;
import com.example.com.onetimer.bean.AttentionBean;
import com.example.com.onetimer.bean.RecommendBean;
import com.example.com.onetimer.component.DaggerHttpComponent;
import com.example.com.onetimer.login.LoginSecondActivity;
import com.example.com.onetimer.onlick.OnItreamClickListener;
import com.example.com.onetimer.recommend.contract.AttentionContract;
import com.example.com.onetimer.recommend.persenter.AttentionPersenter;
import com.example.com.onetimer.ui.ParticularsActivity;
import com.example.com.onetimer.utils.SharedPreferencesUtils;

import java.util.List;

public class Fragment_attention extends BaseFragment<AttentionPersenter> implements AttentionContract.View {
    private RecyclerView rlv;
    private List<AttentionBean.DataBean> list;
    private FragmentManager fragmentManager;

    @Override
    public int getContentLayout() {
        return R.layout.fragment_attention;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        fragmentManager=getActivity().getSupportFragmentManager();
        final Fragment_tags fragment_tags=new Fragment_tags();
        //判断是否登录
        String uid = (String) SharedPreferencesUtils.getParam(getActivity(), "uid", "");
        String token = (String) SharedPreferencesUtils.getParam(getActivity(), "token", "");
        if(uid.equals("")){
            new AlertDialog.Builder(getActivity()).setTitle("抱歉您还没有登录!")
                    .setPositiveButton("立即登录", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent=new Intent(getActivity(), LoginSecondActivity.class);
                            getActivity().startActivity(intent);
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent=new Intent(getActivity(), MainActivity.class);
                    getActivity().startActivity(intent);
                }
            }).show();

        }else{
            mPresenter.getAttention(uid,token);
        }

        rlv=view.findViewById(R.id.attention_rlv);
        //设置布局管理器
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),1,RecyclerView.VERTICAL,false);
        rlv.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void AttentionSuccess(final AttentionBean attentionBean) {
        list=attentionBean.getData();
        AttentionAdapter attentionAdapter=new AttentionAdapter(list,getActivity());
        rlv.setAdapter(attentionAdapter);
        attentionAdapter.setOnItemClickListener(new OnItreamClickListener() {
            @Override
            public void onItemClick(int position) {
                AttentionBean.DataBean mylist = attentionBean.getData().get(position);
                Intent intent=new Intent(getActivity(),ParticularsActivity.class);
                intent.putExtra("mylist",mylist);
                intent.putExtra("sb",2);
                getActivity().startActivity(intent);
            }

            @Override
            public void onLongItemClick(int position) {

            }
        });
    }
}
