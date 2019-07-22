package com.docotel.muhadif.third.ui.fragment.profile.bookmark;

import com.docotel.muhadif.smartcompnews.data.model.response.News;
import com.docotel.muhadif.third.base.BaseView;

import java.util.List;

interface BookmarkView extends BaseView {
    void showData(List<News> newsList);
}
