
package com.docotel.muhadif.smartcompnews.data.model.response;

import com.google.gson.annotations.SerializedName;


public class LikeList {

    @SerializedName("image_url")
    private String mImageUrl;
    @SerializedName("name")
    private String mName;
    @SerializedName("user_id")
    private String mUserId;

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

}
