package com.example.com.onetimer.duanzi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.onetimer.R;
import com.example.com.onetimer.base.BaseFragment;
import com.example.com.onetimer.bean.JokeBean;
import com.example.com.onetimer.component.DaggerHttpComponent;

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
    }
    @Override
    public void onJokeSuccess(JokeBean jokeBean) {

    }
}
