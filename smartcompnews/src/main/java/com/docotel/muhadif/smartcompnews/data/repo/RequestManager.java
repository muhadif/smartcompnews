package com.docotel.muhadif.smartcompnews.data.repo;

import android.content.Context;

import com.docotel.muhadif.smartcompnews.data.model.response.BaseRespone;


import retrofit2.Call;

public class RequestManager {
    public static Call<BaseRespone> getNews(String deviceId, int communityId, String data, int requestId, String secretKey, String apiKey, Context context, String certificateKey, final CallbackInterface callback) {
        Call<BaseRespone> getNews = ApiClient.createRequesst(context, apiKey, certificateKey).getAllNews(deviceId, communityId, data);
        getNews.enqueue(new ApiRequest("200", callback, requestId, secretKey));
        return getNews;
    }

    public static Call<BaseRespone> getDetailNews(String deviceId, int communityId, String data, int requestId, String secretKey, String apiKey, Context context, String certificateKey, final CallbackInterface callback){
        Call<BaseRespone> getDetailNews = ApiClient.createRequesst(context, apiKey, certificateKey).getDetailNews(deviceId, communityId, data);
        getDetailNews.enqueue(new ApiRequest("200", callback, 0, secretKey));
        return getDetailNews;
    }

    public static Call<BaseRespone> getLogin(String deviceId, int communityId, String data, int requestId, String secretKey, String apiKey, Context context, String certificateKey, final CallbackInterface callback) {
        Call<BaseRespone> getLogin = ApiClient.createRequesst(context, apiKey, certificateKey).getLogin(deviceId, communityId, data);
        getLogin.enqueue(new ApiRequest("802", callback, 0, secretKey));
        return getLogin;
    }

    public static Call<BaseRespone> getLogout(String deviceId, int communityId, String data, int requestId, String secretKey, String apiKey, Context context, String certificateKey, final CallbackInterface callback) {
        Call<BaseRespone> getLogout = ApiClient.createRequesst(context, apiKey, certificateKey).getLogout(deviceId, communityId, data);
        getLogout.enqueue(new ApiRequest("200", callback, 0, secretKey));
        return getLogout;
    }

    public enum RequestFailureType {
        SERVICE_FAILURE, HTTP_FAILURE, NETWORK_FAILURE
    }
}
