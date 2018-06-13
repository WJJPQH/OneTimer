package com.example.com.onetimer.video;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.com.onetimer.R;
import com.example.com.onetimer.adapter.HotVideosAdapter;
import com.example.com.onetimer.adapter.NearVideosAdapter;
import com.example.com.onetimer.base.BaseFragment;
import com.example.com.onetimer.bean.HotVideosBean;
import com.example.com.onetimer.bean.NearVideosBean;
import com.example.com.onetimer.component.DaggerHttpComponent;
import com.example.com.onetimer.utils.SharedPreferencesUtils;

import java.util.List;

public class NearbyFragment extends BaseFragment<NearVideosPresenter> implements NearVideosContract.View{

    private RecyclerView nearrv;
    @Override
    public int getContentLayout() {
        return R.layout.nearvideos_fragment;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        nearrv = view.findViewById(R.id.nearrv);
        GridLayoutManager manager = new GridLayoutManager(getActivity(),2,RecyclerView.VERTICAL,false);
        nearrv.setLayoutManager(manager);
        String token = (String) SharedPreferencesUtils.getParam(getActivity(),"token","");
        mPresenter.getNearVideos(token,"1","39.95","116.30");
    }

    @Override
    public void onNearVideosSuccess(NearVideosBean nearVideosBean) {
        List<NearVideosBean.DataBean> list = nearVideosBean.getData();
        NearVideosAdapter nearVideosAdapter = new NearVideosAdapter(getActivity(),list);
        nearrv.setAdapter(nearVideosAdapter);
        nearVideosAdapter.setOnItemClickListener(new NearVideosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(NearVideosBean.DataBean dataBean) {
                Intent intent = new Intent(getActivity(),XiangActivity.class);
                intent.putExtra("bean",dataBean);
                startActivity(intent);
            }
        });
    }
}
