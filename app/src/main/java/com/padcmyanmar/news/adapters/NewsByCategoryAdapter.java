package com.padcmyanmar.news.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daewichan on 1/7/18.
 */

public class NewsByCategoryAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;
    private List<String> mTabTitles;


    public NewsByCategoryAdapter(FragmentManager fm) {
        super(fm);
        mFragments=new ArrayList<>();
        mTabTitles=new ArrayList<>();
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles.get(position);
    }

    public void addTab(String tabTitle, Fragment fragment){
        mTabTitles.add(tabTitle);
        mFragments.add(fragment);
        notifyDataSetChanged();
    }
}
