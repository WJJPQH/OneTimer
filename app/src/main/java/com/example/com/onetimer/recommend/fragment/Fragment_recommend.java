package com.example.com.onetimer.recommend.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.com.onetimer.R;
import com.example.com.onetimer.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class Fragment_recommend extends BaseFragment {
    private TextView rm;
    private TextView gz;
    private String text;
    private RadioGroup group;
    private FrameLayout fragment;
    private FragmentManager fragmentManager;
    private List<Fragment> list_fragment;

    @Override
    public int getContentLayout(){
        return R.layout.recommend_fragment;
    }

    @Override
    public void inject() {

    }

    @Override
    public void initView(View view) {
        fragmentManager = getActivity().getSupportFragmentManager();
        fragment=view.findViewById(R.id.remmend_framelayout);
        group=view.findViewById(R.id.group);
        rm=view.findViewById(R.id.rm);
        gz=view.findViewById(R.id.gz);
        list_fragment=new ArrayList<>();
        list_fragment.add(new Fragment_tags());
        list_fragment.add(new Fragment_attention());
        fragmentManager.beginTransaction().replace(R.id.remmend_framelayout,list_fragment.get(0)).commit();
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rm:
                        fragmentManager.beginTransaction().replace(R.id.remmend_framelayout,list_fragment.get(0)).commit();
                        break;
                    case R.id.gz:
                        fragmentManager.beginTransaction().replace(R.id.remmend_framelayout,list_fragment.get(1)).commit();
                        break;
                }
            }
        });
    }


}
