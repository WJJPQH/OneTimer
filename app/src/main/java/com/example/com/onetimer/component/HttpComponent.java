package com.example.com.onetimer.component;

import com.example.com.onetimer.duanzi.CrossFragment;
import com.example.com.onetimer.module.HttpModule;
import com.example.com.onetimer.reg.RegsActivity;
import com.example.com.onetimer.recommend.fragment.Fragment_tags;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {
    void inject(CrossFragment crossFragment);
    void inject(RegsActivity regsActivity);
    void inject(Fragment_tags fragment_tags);
}
