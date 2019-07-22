package com.docotel.muhadif.third.ui.fragment.profile.bookmark;

import android.content.Context;

import com.docotel.muhadif.smartcompnews.data.model.response.News;
import com.docotel.muhadif.third.helper.PreferenceHelper;
import com.docotel.muhadif.third.base.BasePresenter;

import java.util.List;

public class BookmarkPresenter implements BasePresenter {
    private Context context;
    private BookmarkView view;
    private PreferenceHelper preferenceHelper;

    public BookmarkPresenter(BookmarkView view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void onCreate(Context context) {
        this.context = context;
        view.initView();
        view.initListener();
        preferenceHelper = new PreferenceHelper(context);
        getBookmark();
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

    public void getBookmark() {
        List<News> news = preferenceHelper.getList(PreferenceHelper.BOOKMARK_NEWS, News[].class);

        if(news != null) {
            view.showData(news);
        }

    }
}
