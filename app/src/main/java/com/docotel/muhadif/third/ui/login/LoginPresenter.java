package com.docotel.muhadif.third.ui.login;

import android.content.Context;
import android.util.Log;

import androidx.annotation.Nullable;

import com.docotel.muhadif.smartcompnews.data.model.request.LoginRequest;
import com.docotel.muhadif.smartcompnews.data.model.response.LoginResponse;
import com.docotel.muhadif.smartcompnews.data.repo.RequestManager;
import com.docotel.muhadif.smartcompnews.data.repo.callback.GetCallbackInterface;
import com.docotel.muhadif.smartcompnews.data.repo.callback.GetCallbackLogin;
import com.docotel.muhadif.third.helper.ApplicationHelper;
import com.docotel.muhadif.third.helper.FTAes;
import com.docotel.muhadif.third.helper.JNIHelper;
import com.docotel.muhadif.third.helper.PreferenceHelper;
import com.docotel.muhadif.third.base.BasePresenter;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

public class LoginPresenter implements BasePresenter, GetCallbackInterface {

    private Context context;
    private LoginView view;
    private PreferenceHelper preferenceHelper;

    public LoginPresenter(LoginView view) {
        this.view = view;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void onCreate(Context context) {
        this.context = context;
        preferenceHelper = new PreferenceHelper(context);

        view.initView();
        view.initListener();
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

    public void login(String email, String password) throws UnsupportedEncodingException {
        view.startTask();

        LoginRequest loginRequest = new LoginRequest(email, password, 1, ApplicationHelper.getUID());
        String data = new Gson().toJson(loginRequest);
        String encryptedData = FTAes.encrypt(data, JNIHelper.getEncryption());

        RequestManager.getLogin(ApplicationHelper.getUID(),
                1,
                encryptedData,
                0,
                JNIHelper.getEncryption(),
                JNIHelper.getApi(),
                context,
                new GetCallbackLogin(this));

    }

    public void onGetDataSucess(int requestId, String rawData) {

        LoginResponse tempAccount = new Gson().fromJson(rawData, LoginResponse.class);
        if(tempAccount != null){
            preferenceHelper.putString(PreferenceHelper.LOGGED_ACCOUNT, rawData);
            preferenceHelper.putBoolean(PreferenceHelper.LOGIN_STATE, true);
            view.loginSuccess();
        } else {
            view.loginFailed("Login Failed");
        }
        view.finishedTask();

    }

    public void onGetDataFailure(String s) {
        view.finishedTask();

    }
}
