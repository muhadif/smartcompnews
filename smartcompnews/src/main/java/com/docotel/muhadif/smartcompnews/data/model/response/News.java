
package com.docotel.muhadif.smartcompnews.data.model.response;


import com.google.gson.annotations.SerializedName;


public class News {

    @SerializedName("author")
    private String mAuthor;
    @SerializedName("category_id")
    private String mCategoryId;
    @SerializedName("community_id")
    private String mCommunityId;
    @SerializedName("created_date")
    private String mCreatedDate;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("image_url")
    private String mImageUrl;
    @SerializedName("is_liked")
    private String mIsLiked;
    @SerializedName("like_count")
    private String mLikeCount;
    @SerializedName("news_id")
    private String mNewsId;
    @SerializedName("short_description")
    private String mShortDescription;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private String mType;

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(String categoryId) {
        mCategoryId = categoryId;
    }

    public String getCommunityId() {
        return mCommunityId;
    }

    public void setCommunityId(String communityId) {
        mCommunityId = communityId;
    }

    public String getCreatedDate() {
        return mCreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        mCreatedDate = createdDate;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getIsLiked() {
        return mIsLiked;
    }

    public void setIsLiked(String isLiked) {
        mIsLiked = isLiked;
    }

    public String getLikeCount() {
        return mLikeCount;
    }

    public void setLikeCount(String likeCount) {
        mLikeCount = likeCount;
    }

    public String getNewsId() {
        return mNewsId;
    }

    public void setNewsId(String newsId) {
        mNewsId = newsId;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        mShortDescription = shortDescription;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getmTypeInEnglish(){
        String tipe = "";
        if(getType().equals("berita")){
            tipe = "news";
        } else if (getType().equals("artikel")){
            tipe = "article";
        }
        return tipe;
    }

}
