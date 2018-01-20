package com.exerciseapp.mattiapalmas.giphysampleapp;

import android.content.ContentValues;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by mattia palmas on 2018-01-18.
 */

public class Pager extends FragmentStatePagerAdapter {

    int tabCount;

    public Pager(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount=tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0 :
                FirstFragment firstFragment=new FirstFragment();
                return firstFragment;
            case 1 :
                SecondFragment secondFragment=new SecondFragment();
                return secondFragment;
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
