package com.docotel.muhadif.third.ui.fragment.profile;

import com.docotel.muhadif.smartcompnews.data.model.response.LoginResponse;
import com.docotel.muhadif.smartcompnews.data.model.response.News;
import com.docotel.muhadif.third.base.BaseFragmentView;


import java.util.List;

interface  ProfileView extends BaseFragmentView {
    void showData(List<News> newsList);
    void showAccount(LoginResponse account);
    void checkLogin();
}
