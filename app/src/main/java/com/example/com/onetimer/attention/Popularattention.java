package com.example.com.onetimer.attention;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.com.onetimer.R;
import com.example.com.onetimer.base.BaseFragment;
import com.facebook.drawee.view.SimpleDraweeView;

public class Popularattention extends BaseFragment {
    private View view;
    private SimpleDraweeView mMyattentionTx;
    /**
     * 阿诺玛死定
     */
    private TextView mMyattentionName;
    /**
     * 吃货们快戳我`!
     */
    private TextView mMyattentionQm;
    /**
     * 2017-6-9
     */
    private TextView mMyattentionTime;

    @Override
    public int getContentLayout() {
        return R.layout.myattention_list;
    }

    @Override
    public void inject() {

    }

    @Override
    public void initView(View view) {
        mMyattentionTx = (SimpleDraweeView) view.findViewById(R.id.myattention_tx);
        mMyattentionName = (TextView) view.findViewById(R.id.myattention_name);
        mMyattentionQm = (TextView) view.findViewById(R.id.myattention_qm);
        mMyattentionTime = (TextView) view.findViewById(R.id.myattention_time);
    }

}
