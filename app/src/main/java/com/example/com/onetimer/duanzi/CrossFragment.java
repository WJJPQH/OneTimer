package com.example.com.onetimer.duanzi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.onetimer.R;
import com.example.com.onetimer.adapter.JokeAdapter;
import com.example.com.onetimer.base.BaseFragment;
import com.example.com.onetimer.bean.JokeBean;
import com.example.com.onetimer.component.DaggerHttpComponent;

import java.util.List;

public class CrossFragment extends BaseFragment<JokesPresenter> implements JokesContract.View {

    private RecyclerView rv;


    @Override
    public int getContentLayout() {
        return R.layout.cross_fragment;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        rv = view.findViewById(R.id.rv);
        LinearLayoutManager manager =  new LinearLayoutManager(getActivity());
        rv.setLayoutManager(manager);
        mPresenter.getJoke("1");
    }
    @Override
    public void onJokeSuccess(JokeBean jokeBean) {
        List<JokeBean.DataBean> list = jokeBean.getData();
        JokeAdapter jokeAdapter = new JokeAdapter(getActivity(),list);
        rv.setAdapter(jokeAdapter);
    }
}
