package com.padcmyanmar.news.data.vo;

import java.lang.ref.SoftReference;

import javax.sql.StatementEvent;

/**
 * Created by Daewi on 12/17/2017.
 */

public class PublicationVO {

    private String publicationId;
    private String title;
    private String logo;

    public String getPublicationId() {
        return publicationId;
    }

    public String getTitle() {
        return title;
    }

    public String getLogo() {
        return logo;
    }
}
