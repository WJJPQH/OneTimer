package com.example.com.onetimer.component;

import com.example.com.onetimer.duanzi.CrossFragment;
import com.example.com.onetimer.module.HttpModule;
import com.example.com.onetimer.reg.RegsActivity;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {

    void inject(CrossFragment crossFragment);
    void inject(RegsActivity regsActivity);
}
