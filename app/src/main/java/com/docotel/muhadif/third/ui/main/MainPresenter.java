package com.docotel.muhadif.third.ui.main;

import android.content.Context;

import com.docotel.muhadif.third.base.BasePresenter;

public class MainPresenter implements BasePresenter {

    private Context context;
    private MainView view;

    @Override
    public Context getContext() {
        return null;
    }

    public MainPresenter(MainView view) {
        this.view = view;
    }

    @Override
    public void onCreate(Context context) {
        this.context = context;
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {

    }
}
