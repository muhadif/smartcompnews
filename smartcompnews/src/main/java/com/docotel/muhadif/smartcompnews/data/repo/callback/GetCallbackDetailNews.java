package com.docotel.muhadif.smartcompnews.data.repo.callback;

import androidx.annotation.Nullable;

import com.docotel.muhadif.smartcompnews.data.repo.CallbackInterface;
import com.docotel.muhadif.smartcompnews.data.repo.RequestManager;

public class GetCallbackDetailNews implements CallbackInterface {

    private GetCallbackInterface callback;

    public GetCallbackDetailNews(GetCallbackInterface callback) {
        this.callback = callback;
    }

    @Override
    public void onRequestSuccess(int requestId, @Nullable String rawData) {
        if(rawData != null) {
            callback.onGetDataSucess(requestId, rawData);
        }
    }

    @Override
    public void onRequestFailure(int requestId, RequestManager.RequestFailureType failureType, String errorCode, String message) {
        callback.onGetDataFailure(errorCode + message);

    }
}
