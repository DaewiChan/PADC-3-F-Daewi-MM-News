package com.padcmyanmar.news.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.news.R;
import com.padcmyanmar.news.data.vo.NewsVO;
import com.padcmyanmar.news.delegates.NewsActionDelegate;
import com.padcmyanmar.news.delegates.SportActionDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Daewi on 12/3/2017.
 */

public class ItemSportViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_sport_news)
    TextView tvSportNew;

    @BindView(R.id.iv_sport_fire)
    ImageView ivImage;


    private SportActionDelegate mSportActionDelegate;

    public ItemSportViewHolder(View itemView, SportActionDelegate mSportActionDelegate) {

        super(itemView);
        ButterKnife.bind(this,itemView);

        this.mSportActionDelegate=mSportActionDelegate;
    }

    @OnClick(R.id.cv_sport_item_root)
    public void onNewsItemTap(View view) {
        //Toast.makeText(view.getContext(),"News Item Clicked",Toast.LENGTH_LONG).show();
        mSportActionDelegate.onTapSportItem();

    }

    public void setNews() {

    }


}
