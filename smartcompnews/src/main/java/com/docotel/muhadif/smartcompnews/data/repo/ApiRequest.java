package com.docotel.muhadif.smartcompnews.data.repo;

import android.util.Log;

import com.docotel.muhadif.smartcompnews.data.model.response.BaseRespone;
import com.docotel.muhadif.third.helper.FTAes;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ApiRequest implements Callback<BaseRespone> {
    private String successStatusCode;
    private CallbackInterface callback;
    private int requestId;
    private String secretKey;

    public ApiRequest(String successStatusCode, CallbackInterface callback, int requestId, String secretKey) {
        this.successStatusCode = successStatusCode;
        this.callback = callback;
        this.requestId = requestId;
        this.secretKey = secretKey;
    }

    @Override
    public void onResponse(Call<BaseRespone> call, Response<BaseRespone> response) {
        if(response.code() == 200) {
            String data = FTAes.decrypt(response.body().getData(), secretKey);
            callback.onRequestSuccess(requestId, data);
        }
    }

    @Override
    public void onFailure(Call<BaseRespone> call, Throwable t) {
        String message = "No connection";
        onRequestFailure(RequestManager.RequestFailureType.NETWORK_FAILURE, call, "", message);
    }

    private void onRequestCanceled() {
        Log.i("REQ", "Request canceled");
    }

    private void onRequestFailure(RequestManager.RequestFailureType type, Call<BaseRespone> call, String errorCode, String errorMessage) {
        if (call.isCanceled()) {
            onRequestCanceled();
        } else {
            callback.onRequestFailure(requestId, type, errorCode, errorMessage);
        }
    }
}
