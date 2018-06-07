package com.example.com.onetimer.recommend.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.com.onetimer.R;
import com.example.com.onetimer.adapter.AttentionAdapter;
import com.example.com.onetimer.base.BaseFragment;
import com.example.com.onetimer.bean.AttentionBean;
import com.example.com.onetimer.component.DaggerHttpComponent;
import com.example.com.onetimer.recommend.contract.AttentionContract;
import com.example.com.onetimer.recommend.persenter.AttentionPersenter;

import java.util.List;

public class Fragment_attention extends BaseFragment<AttentionPersenter> implements AttentionContract.View {
    private RecyclerView rlv;
    private List<AttentionBean.DataBean> list;

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
    public void initView(View view) {;
        mPresenter.getAttention("13933","B62A5871AA29A0370D6C4A3B2DB6B87C");
        rlv=view.findViewById(R.id.attention_rlv);
        //设置布局管理器
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),1,RecyclerView.VERTICAL,false);
        rlv.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void AttentionSuccess(AttentionBean attentionBean) {
        list=attentionBean.getData();
        AttentionAdapter attentionAdapter=new AttentionAdapter(list,getActivity());
        rlv.setAdapter(attentionAdapter);
    }
}
