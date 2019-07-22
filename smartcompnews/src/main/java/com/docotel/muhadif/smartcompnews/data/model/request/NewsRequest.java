package com.docotel.muhadif.smartcompnews.data.model.request;

import com.google.gson.annotations.SerializedName;

public class NewsRequest {
    @SerializedName("page")
    private int page;

    @SerializedName("page_size")
    private int pageSize;

    @SerializedName("community_id")
    private int communityId;

    private String keyword;

    @SerializedName("device_id")
    private String deviceId;

    private String type;

    public NewsRequest(int page, int pageSize, int communityId, String keyword, String deviceId, String type) {
        this.page = page;
        this.pageSize = pageSize;
        this.communityId = communityId;
        this.keyword = keyword;
        this.deviceId = deviceId;
        this.type = type;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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
