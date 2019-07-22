
package com.docotel.muhadif.smartcompnews.data.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class NewsDetail {

    @SerializedName("comments")
    private List<Comment> mComments;
    @SerializedName("like_count")
    private Long mLikeCount;
    @SerializedName("like_list")
    private List<LikeList> mLikeList;
    @SerializedName("news")
    private News mNews;
    @SerializedName("terkait")
    private List<Terkait> mTerkait;
    @SerializedName("total_comments")
    private Long mTotalComments;

    public List<Comment> getComments() {
        return mComments;
    }

    public void setComments(List<Comment> comments) {
        mComments = comments;
    }

    public Long getLikeCount() {
        return mLikeCount;
    }

    public void setLikeCount(Long likeCount) {
        mLikeCount = likeCount;
    }

    public List<LikeList> getLikeList() {
        return mLikeList;
    }

    public void setLikeList(List<LikeList> likeList) {
        mLikeList = likeList;
    }

    public News getNews() {
        return mNews;
    }

    public void setNews(News news) {
        mNews = news;
    }

    public List<Terkait> getTerkait() {
        return mTerkait;
    }

    public void setTerkait(List<Terkait> terkait) {
        mTerkait = terkait;
    }

    public Long getTotalComments() {
        return mTotalComments;
    }

    public void setTotalComments(Long totalComments) {
        mTotalComments = totalComments;
    }

}
