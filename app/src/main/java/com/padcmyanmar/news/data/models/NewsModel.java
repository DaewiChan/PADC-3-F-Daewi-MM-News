package com.padcmyanmar.news.data.models;

import android.util.ArrayMap;

import com.padcmyanmar.news.data.vo.NewsVO;
import com.padcmyanmar.news.events.LoadedNewsEvent;
import com.padcmyanmar.news.network.HttpUrlConnectionDataAgent;
import com.padcmyanmar.news.network.NewsDataAgent;
import com.padcmyanmar.news.network.OkHttpDataAgent;
import com.padcmyanmar.news.network.RetrofitDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by daewichan on 12/23/17.
 */

public class NewsModel {
    private static NewsModel sObjInstance;

    private NewsDataAgent mDataAgent;

    private Map<String,NewsVO> mNews;

    private NewsModel(){
       // mDataAgent= HttpUrlConnectionDataAgent.getsObiInstance();
      //  mDataAgent= OkHttpDataAgent.getsObjectInstance();
        mDataAgent= RetrofitDataAgent.getsObjectInstance();

        mNews=new HashMap<>();//inti map object

        EventBus.getDefault().register(this);

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

    /**
     * get News Object by id
     * @param newsId
     * @return
     */
    public NewsVO getNewsById(String newsId){
        return mNews.get(newsId);

    }


    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onNewsLoaded(LoadedNewsEvent event){
       for(NewsVO news : event.getNewsList()) {
           mNews.put(news.getNewsId(),news);
       }
    }
}
