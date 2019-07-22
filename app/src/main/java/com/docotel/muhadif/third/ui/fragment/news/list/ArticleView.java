package com.docotel.muhadif.third.ui.fragment.news.list;

import com.docotel.muhadif.smartcompnews.data.model.response.News;
import com.docotel.muhadif.third.base.BaseFragmentView;

import java.util.List;

public interface ArticleView extends BaseFragmentView {
    void showData(List<News> data);

    void noInternet();
}
