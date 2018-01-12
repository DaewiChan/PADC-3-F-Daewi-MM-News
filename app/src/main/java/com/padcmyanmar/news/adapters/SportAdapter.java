package com.padcmyanmar.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.data.vo.NewsVO;
import com.padcmyanmar.news.delegates.NewsActionDelegate;
import com.padcmyanmar.news.delegates.SportActionDelegate;
import com.padcmyanmar.news.viewholder.ItemNewsViewHolder;
import com.padcmyanmar.news.viewholder.ItemSportViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daewi on 12/3/2017.
 */

public class SportAdapter extends RecyclerView.Adapter<ItemSportViewHolder> {

    private SportActionDelegate mSportActionDelegate;

    private List<NewsVO> mNewsList;

    public SportAdapter(SportActionDelegate mSportActionDelegate) {

        this.mSportActionDelegate=mSportActionDelegate;
        mNewsList = new ArrayList<>();
    }

    @Override
    public ItemSportViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context= parent.getContext();

        LayoutInflater inflater=LayoutInflater.from(context);

        View newsItemView=inflater.inflate(R.layout.item_sport_new, parent, false);

        ItemSportViewHolder itemSportViewHolder=new ItemSportViewHolder(newsItemView,mSportActionDelegate);

        return itemSportViewHolder;
    }



    @Override
    public void onBindViewHolder(ItemSportViewHolder holder, int position) {

      //holder.setNews(mNewsList.get(position));

    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public void setNews(List<NewsVO> newsList){
        mNewsList=newsList;
        notifyDataSetChanged();
    }

}
