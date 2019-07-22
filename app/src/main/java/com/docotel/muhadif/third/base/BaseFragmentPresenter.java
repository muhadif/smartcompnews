package com.docotel.muhadif.third.base;

import android.content.Context;
import android.view.View;

public interface BaseFragmentPresenter {
    Context getContext();
    void onAttach(Context context);
    void onCreateView(View view);
    void onViewCreatated(View view);
    void onDetach();
}
