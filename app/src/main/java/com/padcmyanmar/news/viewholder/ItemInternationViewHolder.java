package com.padcmyanmar.news.viewholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.news.R;
import com.padcmyanmar.news.adapters.InternationTitleScrollAdapter;
import com.padcmyanmar.news.data.vo.NewsVO;
import com.padcmyanmar.news.delegates.InternationActionDelegate;
import com.padcmyanmar.news.delegates.SportActionDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Daewi on 12/3/2017.
 */

public class ItemInternationViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_international_title)
    TextView tvInternationalTitle;

    @BindView(R.id.iv_international_news)
    ImageView ivImage;

    @BindView(R.id.rec_new_title)
    RecyclerView recyclerView;


    public InternationTitleScrollAdapter internationTitleScrollAdapter;

    private InternationActionDelegate mInternationActionDelegate;

    public ItemInternationViewHolder(Context context,View itemView, InternationActionDelegate mInternationActionDelegate) {

        super(itemView);
        ButterKnife.bind(this,itemView);

        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        internationTitleScrollAdapter = new InternationTitleScrollAdapter();
        recyclerView.setAdapter(internationTitleScrollAdapter);

        this.mInternationActionDelegate=mInternationActionDelegate;
    }

    @OnClick(R.id.cv_international_news_item_root)
    public void onNewsItemTap(View view) {
        //Toast.makeText(view.getContext(),"News Item Clicked",Toast.LENGTH_LONG).show();
        mInternationActionDelegate.onTapInternationItem();
    }

    public void setNews(List<NewsVO> newsList){
        //tvInternationalTitle.setText("");
        internationTitleScrollAdapter.setNews(newsList);
    }


 //   public void setNews(NewsVO news) {
//        mNews=news;
//
//        tvPublicationTitle.setText(news.getPublication().getTitle());
//        tvPostedDate.setText(news.getPostedDate());
//        tvNewsBrief.setText(news.getBrief());
//
//        Glide.with(ivPublicationLogo.getContext())
//                .load(news.getPublication().getLogo())
//                .into(ivPublicationLogo);
//
//
//        if (news.getImages() != null) {
//            ivNews.setVisibility(View.VISIBLE);
//            Glide.with(ivNews.getContext())
//                    .load(news.getImages().get(0))
//                    .into(ivNews);
//        }else {
//            ivNews.setVisibility(View.GONE);
//        }
//    }


}
