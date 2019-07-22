package com.docotel.muhadif.smartcompnews.data.model.request;

import com.google.gson.annotations.SerializedName;

public class LogoutRequest {
    public LogoutRequest(String email, int communityId, String deviceId) {
        this.email = email;
        this.communityId = communityId;
        this.deviceId = deviceId;
    }

    @SerializedName("email")
    private String email;

    @SerializedName("community_id")
    private int communityId;

    @SerializedName("device_id")
    private String deviceId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
