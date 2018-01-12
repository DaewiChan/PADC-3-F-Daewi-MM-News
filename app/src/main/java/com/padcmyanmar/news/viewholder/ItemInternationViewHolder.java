package com.padcmyanmar.news.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.delegates.InternationActionDelegate;
import com.padcmyanmar.news.delegates.SportActionDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Daewi on 12/3/2017.
 */

public class ItemInternationViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_brexit)
    TextView tvNewTitle;

    @BindView(R.id.iv_international_brext)
    ImageView ivImage;




    private InternationActionDelegate mInternationActionDelegate;

    public ItemInternationViewHolder(View itemView, InternationActionDelegate mInternationActionDelegate) {

        super(itemView);
        ButterKnife.bind(this,itemView);

        this.mInternationActionDelegate=mInternationActionDelegate;
    }

    @OnClick(R.id.cv_news_item_root)
    public void onNewsItemTap(View view) {
        //Toast.makeText(view.getContext(),"News Item Clicked",Toast.LENGTH_LONG).show();
        mInternationActionDelegate.onTapInternationItem();
    }

    public void setNews() {

    }


}
