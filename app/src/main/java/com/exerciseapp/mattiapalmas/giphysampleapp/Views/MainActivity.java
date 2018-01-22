package com.exerciseapp.mattiapalmas.giphysampleapp.Views;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.exerciseapp.mattiapalmas.giphysampleapp.Modules.GiphyModule;
import com.exerciseapp.mattiapalmas.giphysampleapp.Modules.Pager;
import com.exerciseapp.mattiapalmas.giphysampleapp.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<GiphyModule> favouriteGiphyList;
    public static ProgressDialog progressDialog;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDialogLoadinghiphy(this);
        setContentView(R.layout.activity_main);

        loadGiphyInternalStorage();
        setUpTabs();

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        loadGiphyInternalStorage();
    }

    // Prepare tablayout and viewpager to make fragments swipeable
    private void setUpTabs() {
        mTabLayout = findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);
        favouriteGiphyList = new ArrayList<>();

        mTabLayout.addTab(mTabLayout.newTab().setText("Giphy"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Favourites"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mViewPager = findViewById(R.id.view_pager);
        Pager adapter = new Pager(getSupportFragmentManager(), mTabLayout.getTabCount());
        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setScrollPosition(position, 0, true);
                mTabLayout.setSelected(true);
                FavouriteFragment.loadRecyclerViewData(favouriteGiphyList);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                FavouriteFragment.loadRecyclerViewData(favouriteGiphyList);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    private void loadGiphyInternalStorage() {
        FileInputStream fis = null;
        try {
            fis = getApplicationContext().openFileInput("key");
            ObjectInputStream ois = new ObjectInputStream(fis);
            MainActivity.favouriteGiphyList = (List<GiphyModule>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void setDialogLoadinghiphy(Context context) {
        progressDialog = new ProgressDialog (context) ;
        progressDialog.setCancelable ( false ) ;
        progressDialog.setMessage ( "Retrieving data..." ) ;
        progressDialog.setTitle ( "Please wait" ) ;
        progressDialog.setIndeterminate ( true ) ;
        progressDialog.show();
    }
}


