package com.padcmyanmar.news.delegates;

import com.padcmyanmar.news.data.vo.NewsVO;

/**
 * Created by Daewi on 12/17/2017.
 */

public interface NewsActionDelegate {

     void onTapNewsItem(NewsVO tappedNews);
     void onTapCommentButton();
     void onTapSendToButton();
     void onTapFavoriteButoon();
}
