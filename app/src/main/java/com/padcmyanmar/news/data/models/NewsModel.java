package com.padcmyanmar.news.data.models;

import com.padcmyanmar.news.network.HttpUrlConnectionDataAgent;
import com.padcmyanmar.news.network.NewsDataAgent;
import com.padcmyanmar.news.network.OkHttpDataAgent;

/**
 * Created by daewichan on 12/23/17.
 */

public class NewsModel {
    private static NewsModel sObjInstance;

    private NewsDataAgent mDataAgent;

    private NewsModel(){
       // mDataAgent= HttpUrlConnectionDataAgent.getsObiInstance();
        mDataAgent= OkHttpDataAgent.getsObjectInstance();

    }

    public static NewsModel getsObjInstance(){
        if (sObjInstance==null){
            sObjInstance=new NewsModel();
        }
        return sObjInstance;
    }

    /**
     * load news from network api.
     */

    public void loadNews(){
        mDataAgent.loadNews();

    }
}
