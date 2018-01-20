package com.padcmyanmar.news.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.padcmyanmar.news.MMNewsApp;
import com.padcmyanmar.news.events.LoadedNewsEvent;
import com.padcmyanmar.news.network.responses.GetNewsResponse;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.io.StringReader;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by daewichan on 1/6/18.
 */

public class OkHttpDataAgent implements NewsDataAgent {
    @Override
    public void loginUser(String email, String password) {

    }

    private static OkHttpDataAgent sObjectInstance;

    private OkHttpDataAgent(){

    }

    public static OkHttpDataAgent getsObjectInstance(){
        if (sObjectInstance==null){
            sObjectInstance=new OkHttpDataAgent();
        }
        return sObjectInstance;
    }
    @Override
    public void loadNews() {

        new LoadNewsTask().execute("http://padcmyanmar.com/padc-3/mm-news/apis/v1/getMMNews.php");
    }

    private static class LoadNewsTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {
            String url= urls[0];

            OkHttpClient httpClient=new OkHttpClient.Builder()//1
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15,TimeUnit.SECONDS)
                    .readTimeout(60,TimeUnit.SECONDS)
                    .build();

            RequestBody formBody = new FormBody.Builder() //2.
                    .add("access_token", "b002c7e1a528b7cb460933fc2875e916")
                    .add("page", "1")
                    .build();

            Request request=new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();

            String responseString= null;

            try {
                Response response = httpClient.newCall(request).execute(); //4.
                if (response.isSuccessful() && response.body() != null) {
                    responseString = response.body().string();
                }
            } catch (Exception e) {
                Log.e(MMNewsApp.LOG_TAG, e.getMessage());
            }

            return responseString;
        }
        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);

            Gson gson=new Gson();
            GetNewsResponse getNewsResponse= gson.fromJson(response, GetNewsResponse.class);

            LoadedNewsEvent event=new LoadedNewsEvent(getNewsResponse.getMmNews());
            EventBus eventBus=EventBus.getDefault();
            eventBus.post(event);
        }
    }

}
