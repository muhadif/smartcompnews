
package com.docotel.muhadif.smartcompnews.data.model.response;

import com.google.gson.annotations.SerializedName;

public class AllList {

    @SerializedName("all")
    private java.util.List<News> mNews;

    public java.util.List<News> getNews() {
        return mNews;
    }

    public void setNews(java.util.List<News> news) {
        mNews = news;
    }

}
