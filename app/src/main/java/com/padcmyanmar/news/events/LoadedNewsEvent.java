package com.padcmyanmar.news.events;

import com.padcmyanmar.news.data.vo.NewsVO;

import java.util.List;

/**
 * Created by daewichan on 12/24/17.
 */

public class LoadedNewsEvent {

    private List<NewsVO> newsList;

    public LoadedNewsEvent(List<NewsVO> newsList) {
        this.newsList = newsList;
    }

    public List<NewsVO> getNewsList() {
        return newsList;
    }
}
