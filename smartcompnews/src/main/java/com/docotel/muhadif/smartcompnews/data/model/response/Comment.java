
package com.docotel.muhadif.smartcompnews.data.model.response;


import com.google.gson.annotations.SerializedName;


public class Comment {

    @SerializedName("approved_by")
    private String mApprovedBy;
    @SerializedName("approved_date")
    private String mApprovedDate;
    @SerializedName("comment")
    private String mComment;
    @SerializedName("created_date")
    private String mCreatedDate;
    @SerializedName("firstname")
    private String mFirstname;
    @SerializedName("idn_created_date")
    private String mIdnCreatedDate;
    @SerializedName("image_profil")
    private String mImageProfil;
    @SerializedName("is_active")
    private String mIsActive;
    @SerializedName("is_approve")
    private String mIsApprove;
    @SerializedName("lastname")
    private String mLastname;
    @SerializedName("news_comment_id")
    private String mNewsCommentId;
    @SerializedName("news_id")
    private String mNewsId;
    @SerializedName("user_id")
    private String mUserId;

    public String getApprovedBy() {
        return mApprovedBy;
    }

    public void setApprovedBy(String approvedBy) {
        mApprovedBy = approvedBy;
    }

    public String getApprovedDate() {
        return mApprovedDate;
    }

    public void setApprovedDate(String approvedDate) {
        mApprovedDate = approvedDate;
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        mComment = comment;
    }

    public String getCreatedDate() {
        return mCreatedDate;
    }

    public void setCreatedDate(String createdDate) {
        mCreatedDate = createdDate;
    }

    public String getFirstname() {
        return mFirstname;
    }

    public void setFirstname(String firstname) {
        mFirstname = firstname;
    }

    public String getIdnCreatedDate() {
        return mIdnCreatedDate;
    }

    public void setIdnCreatedDate(String idnCreatedDate) {
        mIdnCreatedDate = idnCreatedDate;
    }

    public String getImageProfil() {
        return mImageProfil;
    }

    public void setImageProfil(String imageProfil) {
        mImageProfil = imageProfil;
    }

    public String getIsActive() {
        return mIsActive;
    }

    public void setIsActive(String isActive) {
        mIsActive = isActive;
    }

    public String getIsApprove() {
        return mIsApprove;
    }

    public void setIsApprove(String isApprove) {
        mIsApprove = isApprove;
    }

    public String getLastname() {
        return mLastname;
    }

    public void setLastname(String lastname) {
        mLastname = lastname;
    }

    public String getNewsCommentId() {
        return mNewsCommentId;
    }

    public void setNewsCommentId(String newsCommentId) {
        mNewsCommentId = newsCommentId;
    }

    public String getNewsId() {
        return mNewsId;
    }

    public void setNewsId(String newsId) {
        mNewsId = newsId;
    }

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }

}
