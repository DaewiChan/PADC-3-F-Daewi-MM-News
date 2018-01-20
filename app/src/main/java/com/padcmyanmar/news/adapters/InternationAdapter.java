package com.padcmyanmar.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.data.vo.NewsVO;
import com.padcmyanmar.news.delegates.InternationActionDelegate;
import com.padcmyanmar.news.delegates.SportActionDelegate;
import com.padcmyanmar.news.viewholder.ItemInternationViewHolder;
import com.padcmyanmar.news.viewholder.ItemSportViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daewi on 12/3/2017.
 */

public class InternationAdapter extends RecyclerView.Adapter<ItemInternationViewHolder> {

    private InternationActionDelegate mInternationalActionDelegate;

    private List<NewsVO> mNewsList;

    public InternationAdapter(InternationActionDelegate mInternationalActionDelegate) {

        this.mInternationalActionDelegate=mInternationalActionDelegate;
        mNewsList = new ArrayList<>();
    }

    @Override
    public ItemInternationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context= parent.getContext();

        LayoutInflater inflater=LayoutInflater.from(context);

        View newsItemView=inflater.inflate(R.layout.item_international_news, parent, false);

        ItemInternationViewHolder itemInternationViewHolder=new ItemInternationViewHolder(context,newsItemView,mInternationalActionDelegate);

        return itemInternationViewHolder;
    }



    @Override
    public void onBindViewHolder(ItemInternationViewHolder holder, int position) {


       // holder.internationTitleScrollAdapter.setNews(mNewsList);

     holder.setNews(mNewsList);

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
