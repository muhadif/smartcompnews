package com.docotel.muhadif.smartcompnews.data.repo;

import com.docotel.muhadif.smartcompnews.data.model.response.BaseRespone;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("news/get-all")
    Call<BaseRespone> getAllNews(
            @Field("device_id") String deviceId,
            @Field("community_id") int communityId,
            @Field("data") String data
    );

    @FormUrlEncoded
    @POST("news/get-detail")
    Call<BaseRespone> getDetailNews(
            @Field("device_id") String deviceId,
            @Field("community_id") int communityId,
            @Field("data") String data
    );

    @FormUrlEncoded
    @POST("login")
    Call<BaseRespone> getLogin(
            @Field("device_id") String deviceId,
            @Field("community_id") int communityId,
            @Field("data") String data
    );

    @FormUrlEncoded
    @POST("user/logout")
    Call<BaseRespone> getLogout(
            @Field("device_id") String deviceId,
            @Field("community_id") int communityId,
            @Field("data") String data
    );

}
