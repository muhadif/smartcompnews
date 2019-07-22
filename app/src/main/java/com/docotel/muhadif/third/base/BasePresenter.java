package com.docotel.muhadif.third.base;

import android.content.Context;

public interface BasePresenter {
    Context getContext();
    void onCreate(Context context);
    void onPause();
    void onResume();
    void onDestroy();
}
