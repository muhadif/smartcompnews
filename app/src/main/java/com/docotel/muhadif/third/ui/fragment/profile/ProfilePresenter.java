package com.docotel.muhadif.third.ui.fragment.profile;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.docotel.muhadif.smartcompnews.data.model.request.LogoutRequest;
import com.docotel.muhadif.smartcompnews.data.model.response.LoginResponse;
import com.docotel.muhadif.smartcompnews.data.repo.RequestManager;
import com.docotel.muhadif.smartcompnews.data.repo.callback.GetCallbackInterface;
import com.docotel.muhadif.smartcompnews.data.repo.callback.GetCallbackLogout;
import com.docotel.muhadif.third.helper.ApplicationHelper;
import com.docotel.muhadif.third.helper.FTAes;
import com.docotel.muhadif.third.helper.JNIHelper;
import com.docotel.muhadif.third.helper.PreferenceHelper;
import com.docotel.muhadif.third.base.BaseFragmentPresenter;
import com.google.gson.Gson;



public class ProfilePresenter implements BaseFragmentPresenter, GetCallbackInterface {
    Context context;
    ProfileView mView;
    private PreferenceHelper preferenceHelper;

    public ProfilePresenter(ProfileView view) {
        this.mView = view;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void onAttach(Context context) {
        this.context = context;
        preferenceHelper = new PreferenceHelper(context);
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

    public void logout(String email) {
        Log.d("EMAIL", email);
        LogoutRequest logoutRequest = new LogoutRequest(email, 1, ApplicationHelper.getUID());
        String data = new Gson().toJson(logoutRequest);
        String encryptedData = FTAes.encrypt(data, JNIHelper.getEncryption());
        RequestManager.getLogout(ApplicationHelper.getUID(),
                1,
                encryptedData,
                0,
                JNIHelper.getEncryption(),
                JNIHelper.getApi(),
                context,
                JNIHelper.getCertificate(),
                new GetCallbackLogout(this));

    }

    public void getLoggedAccount() {
        String jsonAccount = preferenceHelper.getString(PreferenceHelper.LOGGED_ACCOUNT);
        LoginResponse account = new Gson().fromJson(jsonAccount, LoginResponse.class);

        mView.showAccount(account);

    }

    public void onGetDataSucess(int requestId, String rawData) {
        preferenceHelper.putString(PreferenceHelper.LOGGED_ACCOUNT, null);
        preferenceHelper.putBoolean(PreferenceHelper.LOGIN_STATE, false);
        mView.checkLogin();
    }

    public void onGetDataFailure(String s) {
    }
}
