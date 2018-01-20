package com.exerciseapp.mattiapalmas.giphysampleapp;

import android.graphics.PorterDuff;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpTabs();
    }


    // Prepare tablayout and viewpager to make fragments swipeable
    private void setUpTabs() {
        mTabLayout=findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.addTab(mTabLayout.newTab().setText("Tab1"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab2"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);



        mViewPager = findViewById(R.id.view_pager);
        Pager adapter=new Pager(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(adapter);




        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setScrollPosition(position, 0, true);
                mTabLayout.setSelected(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}


