package com.padcmyanmar.news.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.news.MMNewsApp;
import com.padcmyanmar.news.R;
import com.padcmyanmar.news.adapters.InternationAdapter;
import com.padcmyanmar.news.data.models.NewsModel;
import com.padcmyanmar.news.delegates.InternationActionDelegate;
import com.padcmyanmar.news.events.LoadedNewsEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by daewichan on 1/7/18.
 */

public class InternationalNewsFragment extends Fragment implements InternationActionDelegate{

    @BindView(R.id.rv_international_news)
    RecyclerView rvInternation;

    private InternationAdapter mInternationAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_international_news, container, false);
        ButterKnife.bind(this,view);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,true);
        rvInternation.setLayoutManager(linearLayoutManager);

        mInternationAdapter=new InternationAdapter(this);
        rvInternation.setAdapter(mInternationAdapter);

        NewsModel.getsObjInstance().loadNews();
        return view;
    }

    @Override
    public void onTapInternationItem() {

    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsByCategotyLoaded(LoadedNewsEvent event){
        Log.d(MMNewsApp.LOG_TAG,"onNewsCategoryLoaded"+event.getNewsList().size());
        mInternationAdapter.setNews(event.getNewsList());
    }

}
