package com.padcmyanmar.news.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.delegates.BeforeLoginDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by daewichan on 1/20/18.
 */

public class BeforeUserLoginViewPod extends RelativeLayout {

    private BeforeLoginDelegate mDelegate;

    public BeforeUserLoginViewPod(Context context) {
        super(context);
    }

    public BeforeUserLoginViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeUserLoginViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }

    public void setDelegate(BeforeLoginDelegate delegate){
        mDelegate=delegate;
    }


    @OnClick(R.id.btn_to_login)
    public void onTapLogin(View view){
        mDelegate.onTapToLogin();

    }

    @OnClick(R.id.btn_to_register)
    public void onTapRegister(View view){
        mDelegate.onTapToRegister();


    }

}
