package com.docotel.muhadif.smartcompnews.data.model.request;

import android.util.Base64;

import com.docotel.muhadif.third.helper.FTAes;
import com.google.gson.annotations.SerializedName;

import java.io.UnsupportedEncodingException;



public class LoginRequest {

    public LoginRequest(String email, String password, int communityId, String deviceId) throws UnsupportedEncodingException {
        this.email = email;
        this.password = password;
        this.communityId = communityId;
        this.deviceId = deviceId;
        this.hash = encryptEmailPassword(email, password);
    }

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("community_id")
    private int communityId;

    @SerializedName("device_id")
    private String deviceId;

    @SerializedName("hash")
    private String hash;

    private String  encryptEmailPassword(String email, String password) throws UnsupportedEncodingException {
        String chiper = email + password;
        String hash = Base64.encodeToString(FTAes.sha256(chiper).getBytes("UTF-8"), Base64.DEFAULT);
        return hash.replace("\n", "");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
