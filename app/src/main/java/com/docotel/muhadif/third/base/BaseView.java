package com.docotel.muhadif.third.base;

public interface BaseView {
    void initView();
    void initListener();
    void startTask();
    void finishedTask();
    void failureTask(String message);
    void info(String message);
}
