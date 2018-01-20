package com.padcmyanmar.news.viewholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.adapters.InternationTitleScrollAdapter;
import com.padcmyanmar.news.data.vo.NewsVO;
import com.padcmyanmar.news.delegates.InternationActionDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Daewi on 12/3/2017.
 */

public class ItemInternationScrollViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title_scroll)
        TextView tvNewTitle;

        public ItemInternationScrollViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setScrollTitle(){
            tvNewTitle.setText("Scroll Title");
        }
    }
