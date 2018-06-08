package com.example.com.onetimer.recommend.fragment;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.com.onetimer.R;
import com.example.com.onetimer.adapter.RecommendAdapter;
import com.example.com.onetimer.base.BaseFragment;
import com.example.com.onetimer.bean.RecommendBean;
import com.example.com.onetimer.component.DaggerHttpComponent;
import com.example.com.onetimer.recommend.contract.RecommendContract;
import com.example.com.onetimer.recommend.persenter.RecommendPersenter;
import com.example.com.onetimer.utils.GlideImageLoader;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class Fragment_tags extends BaseFragment<RecommendPersenter> implements RecommendContract.View{
    private Banner banner;
    private List<String> img_list;
    private XRecyclerView rlv;


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
        mPresenter.getRecommend(""+10);
        //设置布局管理器
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),1,RecyclerView.VERTICAL,false);
        rlv.setLayoutManager(gridLayoutManager);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        //结束轮播
        banner.stopAutoPlay();
    }

    @Override
    public void recommendSuccess(RecommendBean recommendBean) {
        List<RecommendBean.DataBean> list = recommendBean.getData();
        RecommendAdapter recommendAdapter=new RecommendAdapter(list,getActivity());
        rlv.setAdapter(recommendAdapter);
    }
}
