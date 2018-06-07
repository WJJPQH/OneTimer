package com.example.com.onetimer.recommend.fragment;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.com.onetimer.MainActivity;
import com.example.com.onetimer.R;
import com.example.com.onetimer.adapter.RecommendAdapter;
import com.example.com.onetimer.base.BaseFragment;
import com.example.com.onetimer.bean.RecommendBean;
import com.example.com.onetimer.component.DaggerHttpComponent;
import com.example.com.onetimer.login.LoginActivity;
import com.example.com.onetimer.onlick.OnItreamClickListener;
import com.example.com.onetimer.recommend.contract.RecommendContract;
import com.example.com.onetimer.recommend.persenter.RecommendPersenter;
import com.example.com.onetimer.ui.ParticularsActivity;
import com.example.com.onetimer.utils.GlideImageLoader;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

import static android.content.Context.SENSOR_SERVICE;

public class Fragment_tags extends BaseFragment<RecommendPersenter> implements RecommendContract.View{
    private Banner banner;
    private List<String> img_list;
    private XRecyclerView rlv;
    private JCVideoPlayer.JCAutoFullscreenListener sensorEventListener;
    private SensorManager sensorManager;
    private boolean isRefresh=true;
    private List<RecommendBean.DataBean> allList=new ArrayList<>();
    private List<RecommendBean.DataBean> list;
    private RecommendAdapter recommendAdapter;

    private int num=10;
    @Override
    public int getContentLayout() {
        return R.layout.tags_fragment;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {
        sensorManager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);
        sensorEventListener = new JCVideoPlayer.JCAutoFullscreenListener();
        banner=view.findViewById(R.id.banner);
        rlv=view.findViewById(R.id.tags_RLV);
        Uri uri=Uri.parse(""+R.drawable.ad1);
        img_list=new ArrayList<>();
        img_list.add("https://www.zhaoapi.cn/images/quarter/ad4.png");
        img_list.add("https://www.zhaoapi.cn/images/quarter/ad1.png");
        img_list.add("https://www.zhaoapi.cn/images/quarter/ad2.png");
        img_list.add("https://www.zhaoapi.cn/images/quarter/ad3.png");
        banner.setImages(img_list);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //开始轮播
        banner.start();
        rlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                //刷新
                isRefresh=true;
                num=10;
               mPresenter.getRecommend(""+num);
            }

            @Override
            public void onLoadMore() {
                //加载更多
                isRefresh=false;
                num+=10;
                mPresenter.getRecommend(""+num);
            }
        });
        mPresenter.getRecommend(""+10);
        //设置布局管理器
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),1,RecyclerView.VERTICAL,false);
        rlv.setLayoutManager(gridLayoutManager);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        //结束轮播
        banner.stopAutoPlay();
    }

    @Override
    public void recommendSuccess(final RecommendBean recommendBean) {
        list = recommendBean.getData();
        allList.addAll(list);
        setadapter();
        recommendAdapter.setOnItemClickListener(new OnItreamClickListener() {
            @Override
            public void onItemClick(int position) {
                RecommendBean.DataBean mylist = recommendBean.getData().get(position);
                Intent intent=new Intent(getActivity(),ParticularsActivity.class);
                intent.putExtra("mylist",mylist);
                intent.putExtra("lo","ppp");
                getActivity().startActivity(intent);
            }

            @Override
            public void onLongItemClick(int position) {

            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
    //设置适配器
    private void setadapter() {
        if(isRefresh){
            recommendAdapter=new RecommendAdapter(list,getActivity());
            rlv.setAdapter(recommendAdapter);
            recommendAdapter.refresh(allList);
            rlv.refreshComplete();//设置刷新完成
        }else{
            if(recommendAdapter!=null){
                recommendAdapter.loadMore(allList);
                rlv.loadMoreComplete();//设置加载更多完成
            }
        }
        if (recommendAdapter==null){
            return;
        }

    }

}
