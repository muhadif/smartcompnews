package com.docotel.muhadif.smartcompnews.data.repo.callback;

import android.util.Log;

import androidx.annotation.Nullable;
;import com.docotel.muhadif.smartcompnews.data.repo.CallbackInterface;
import com.docotel.muhadif.smartcompnews.data.repo.RequestManager;

public class GetCallbackNews implements CallbackInterface {

    private GetCallbackInterface callback;

    public GetCallbackNews(GetCallbackInterface callback) {
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
