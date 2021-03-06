package com.padcmyanmar.news.data.vo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Daewi on 12/17/2017.
 */

public class NewsVO {
    @SerializedName("news-id")
    private String newsId;
    private String brief;
    private String details;
    private List<String> images;

    @SerializedName("posted-date")
    private String postedDate;

    private PublicationVO publication;
    private List<FavoriteVO> favorites;
    private List<CommentVO> comments;

    @SerializedName("send-tos")
    private List<SentToVO> sentTo;

    public String getNewsId() {
        return newsId;
    }

    public String getBrief() {
        return brief;}

    public String getDetails() {
        return details;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public PublicationVO getPublication() {
        return publication;
    }

    public List<String> getImages() {
        return images;
    }

    public List<FavoriteVO> getFavorites() {
        return favorites;
    }

    public List<CommentVO> getComments() {
        return comments;
    }

    public List<SentToVO> getSentTo() {
        return sentTo;
    }
}
