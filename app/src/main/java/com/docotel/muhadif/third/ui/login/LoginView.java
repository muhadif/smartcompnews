package com.docotel.muhadif.third.ui.login;

import com.docotel.muhadif.third.base.BaseView;

public interface LoginView extends BaseView {

    void loginSuccess();
    void loginFailed(String message);

}
