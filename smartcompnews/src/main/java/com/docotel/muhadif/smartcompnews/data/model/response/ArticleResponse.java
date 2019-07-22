
package com.docotel.muhadif.smartcompnews.data.model.response;


import com.google.gson.annotations.SerializedName;

public class ArticleResponse {

    @SerializedName("list")
    private ArticleList articleList;

    public ArticleList getList() {
        return articleList;
    }

    public void setList(ArticleList list) {
        articleList = list;
    }

}
