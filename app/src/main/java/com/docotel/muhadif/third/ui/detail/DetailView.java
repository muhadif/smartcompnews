package com.docotel.muhadif.third.ui.detail;

import com.docotel.muhadif.smartcompnews.data.model.response.NewsDetail;
import com.docotel.muhadif.third.base.BaseView;

public interface DetailView extends BaseView {
    void showData(NewsDetail newsDetail);
    void isBooked(Boolean state);
}
