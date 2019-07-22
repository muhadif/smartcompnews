
package com.docotel.muhadif.smartcompnews.data.model.response;


import com.google.gson.annotations.SerializedName;

public class NewsResponse {

    @SerializedName("list")
    private NewsList newsList;

    public NewsList getList() {
        return newsList;
    }

    public void setList(NewsList list) {
        newsList = list;
    }

}
