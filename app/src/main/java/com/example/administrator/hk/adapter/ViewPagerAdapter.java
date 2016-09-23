package com.example.administrator.hk.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.administrator.hk.fragment.ViewPagerFragment;

/**
 * Created by Administrator on 2016/9/22.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private int[] pic;
    public ViewPagerAdapter(FragmentManager fm,int[] pic) {

        super(fm);
        this.pic = pic;
    }

    @Override
    public Fragment getItem(int position) {
        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();

            viewPagerFragment.intData(pic[position]);

        return viewPagerFragment;
    }

    @Override
    public int getCount() {
        return pic.length;
    }
}
