package com.exerciseapp.mattiapalmas.giphysampleapp.Modules;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.exerciseapp.mattiapalmas.giphysampleapp.Views.FavouriteFragment;
import com.exerciseapp.mattiapalmas.giphysampleapp.Views.GiphyFragment;

/**
 * Created by mattia palmas on 2018-01-18.
 */

public class Pager extends FragmentStatePagerAdapter {

    int tabCount;

    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                GiphyFragment firstFragment = new GiphyFragment();
                return firstFragment;
            case 1:
                FavouriteFragment secondFragment = new FavouriteFragment();
                return secondFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
