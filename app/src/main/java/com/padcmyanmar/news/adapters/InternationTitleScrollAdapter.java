package com.padcmyanmar.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.data.vo.NewsVO;
import com.padcmyanmar.news.viewholder.ItemInternationScrollViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daewi on 12/3/2017.
 */

public class InternationTitleScrollAdapter extends RecyclerView.Adapter<ItemInternationScrollViewHolder> {

    private List<NewsVO> mNewsList;

    public InternationTitleScrollAdapter() {

        mNewsList = new ArrayList<>();
    }

    @Override
    public ItemInternationScrollViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context= parent.getContext();

        LayoutInflater inflater=LayoutInflater.from(context);

        View newsItemView=inflater.inflate(R.layout.item_international_title_scroll, parent, false);

        ItemInternationScrollViewHolder itemInternationViewHolder=new ItemInternationScrollViewHolder(newsItemView);

        return itemInternationViewHolder;
    }



    @Override
    public void onBindViewHolder(ItemInternationScrollViewHolder holder, int position) {
        holder.setScrollTitle();
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
