package com.docotel.muhadif.third.ui.fragment.news;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.docotel.muhadif.third.base.BaseFragmentPresenter;


public class NewsPresenter implements BaseFragmentPresenter {
    private NewsView mView;
    private Context context;

    public NewsPresenter(NewsView mView) {
        this.mView = mView;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
    }

    @Override
    public void onCreateView(View view) {
        mView.initView(view);
        mView.initListener();
    }

    @Override
    public void onViewCreatated(View view) {

    }

    @Override
    public void onDetach() {

    }
}
