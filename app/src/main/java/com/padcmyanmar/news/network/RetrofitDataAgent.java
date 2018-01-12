package com.padcmyanmar.news.network;

import android.util.Log;

import com.google.gson.Gson;
import com.padcmyanmar.news.events.LoadedNewsEvent;
import com.padcmyanmar.news.network.responses.GetNewsResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by daewichan on 1/6/18.
 */

public class RetrofitDataAgent implements NewsDataAgent {

    private static RetrofitDataAgent sObjectInstance;


    public RetrofitDataAgent() {
    }

    public static RetrofitDataAgent getsObjectInstance() {
        if (sObjectInstance == null)
            sObjectInstance = new RetrofitDataAgent();
            return sObjectInstance;
    }

    @Override
    public void loadNews() {

        OkHttpClient httpClient=new OkHttpClient.Builder()//1
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder()//1
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();

        NewsApi newsApi= retrofit.create(NewsApi.class);


     Call<GetNewsResponse> getNewsResponseCall= newsApi.loadNews(1, "b002c7e1a528b7cb460933fc2875e916");

     getNewsResponseCall.enqueue(new Callback<GetNewsResponse>() {
         @Override
         public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {
             GetNewsResponse getNewsResponse=response.body();
             if(getNewsResponse.getMmNews()==null){
                 LoadedNewsEvent event=new LoadedNewsEvent(getNewsResponse.getMmNews());
                 EventBus.getDefault().post(event);
             }
         }

         @Override
         public void onFailure(Call<GetNewsResponse> call, Throwable t) {

         }
     });
    }
}
