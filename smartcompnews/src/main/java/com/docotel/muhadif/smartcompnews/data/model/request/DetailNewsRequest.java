package com.docotel.muhadif.smartcompnews.data.model.request;

import com.google.gson.annotations.SerializedName;

public class DetailNewsRequest {
    public DetailNewsRequest(int communityId, String newsId, String deviceId, String type) {
        this.communityId = communityId;
        this.newsId = newsId;
        this.deviceId = deviceId;
        this.type = type;
    }

    @SerializedName("community_id")
    private int communityId;

    @SerializedName("news_id")
    private String newsId;

    @SerializedName("device_id")
    private String deviceId;

    private String type;

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
