package com.example.com.onetimer.video;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.onetimer.R;
import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_fragment,null);
        tabLayout = view.findViewById(R.id.tab);
        viewPager = view.findViewById(R.id.viewpager);
        inittab();
        viewPager.setAdapter(new MyAdapter(getActivity().getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
    private void inittab() {
        list = new ArrayList<>();
        list.add("热门");
        list.add("附近");
    }
    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                HotVideoFragment hotVideoFragment = new HotVideoFragment();
                return hotVideoFragment;
            } else{
                NearbyFragment nearbyFragment = new NearbyFragment();
                return nearbyFragment;
            }
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
