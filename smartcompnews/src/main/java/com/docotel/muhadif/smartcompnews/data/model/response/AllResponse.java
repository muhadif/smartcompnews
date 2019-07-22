
package com.docotel.muhadif.smartcompnews.data.model.response;


import com.google.gson.annotations.SerializedName;

public class AllResponse {

    @SerializedName("list")
    private AllList articleList;

    public AllList getList() {
        return articleList;
    }

    public void setList(AllList list) {
        articleList = list;
    }

}
