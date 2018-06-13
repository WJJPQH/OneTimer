package com.example.com.onetimer.video;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.com.onetimer.R;
import com.example.com.onetimer.adapter.HotVideosAdapter;
import com.example.com.onetimer.base.BaseFragment;
import com.example.com.onetimer.bean.HotVideosBean;
import com.example.com.onetimer.component.DaggerHttpComponent;
import com.example.com.onetimer.utils.SharedPreferencesUtils;

import java.io.Serializable;
import java.util.List;

public class HotVideoFragment extends BaseFragment<HotVideosPresenter> implements HotVideosContract.View{
    public static final int HOTVIDEO = 1 ;
    private RecyclerView videorv;
    @Override
    public int getContentLayout() {
        return R.layout.hotvideos_fragment;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        videorv = view.findViewById(R.id.videorv);
        GridLayoutManager manager = new GridLayoutManager(getActivity(),2,RecyclerView.VERTICAL,false);
        videorv.setLayoutManager(manager);
        String token = (String) SharedPreferencesUtils.getParam(getActivity(),"token","");
        mPresenter.getHotVideos(token,"1");
    }

    @Override
    public void onHotVideosSuccess(final HotVideosBean hotVideosBean) {
        List<HotVideosBean.DataBean> list = hotVideosBean.getData();
        HotVideosAdapter hotVideosAdapter = new HotVideosAdapter(getActivity(),list);
        videorv.setAdapter(hotVideosAdapter);
        hotVideosAdapter.setOnItemClickListener(new HotVideosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(HotVideosBean.DataBean dataBean) {
                Intent intent =new Intent(getActivity(),XiangActivity.class);
                intent.putExtra("bean",dataBean);
                intent.putExtra("flag",HOTVIDEO);
                startActivity(intent);
            }
        });
    }
}
