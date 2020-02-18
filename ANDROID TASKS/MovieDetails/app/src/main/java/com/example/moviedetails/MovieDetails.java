package com.example.moviedetails;

public class MovieDetails {
    private String mImageUrl;
    private String mCreator;
    private int mLikes;
    private String mComments;

    public MovieDetails(String mImageUrl, String mCreator, int mLikes, String mComments) {
        this.mImageUrl = mImageUrl;
        this.mCreator = mCreator;
        this.mLikes = mLikes;
        this.mComments = mComments;
    }


    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getCreator() {
        return mCreator;
    }

    public void setCreator(String mCreator) {
        this.mCreator = mCreator;
    }

    public int getLikeCount() {
        return mLikes;
    }

    public void setLikeCount(int mLikes) {
        this.mLikes = mLikes;
    }

    public String getComments() {
        return mComments;
    }

    public void setComments(String mComments) {
        this.mComments = mComments;
    }

}
