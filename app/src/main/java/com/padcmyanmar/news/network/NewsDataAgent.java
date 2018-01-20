package com.padcmyanmar.news.network;

/**
 * Created by daewichan on 12/23/17.
 */

public interface NewsDataAgent {
    /**
     * load news from network api.
     */
    void loadNews();

    void loginUser(String email,String password);
}
