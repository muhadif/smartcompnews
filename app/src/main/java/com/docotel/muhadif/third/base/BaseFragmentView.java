package com.docotel.muhadif.third.base;

import android.view.View;

public interface BaseFragmentView {
    void initView(View view);
    void initListener();
    void startTask();
    void finishedTask();
    void failureTask(String message);
    void info(String message);
}
