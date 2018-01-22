package com.exerciseapp.mattiapalmas.giphysampleapp.Views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exerciseapp.mattiapalmas.giphysampleapp.Modules.GiphyModule;
import com.exerciseapp.mattiapalmas.giphysampleapp.Presenters.AdaptorRecyclerViewFavourite;
import com.exerciseapp.mattiapalmas.giphysampleapp.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends Fragment {

    static View view;
    static RecyclerView recyclerViewFavourites;
    static RecyclerView.Adapter adapter;

    public FavouriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favourite, container, false);

        loadRecyclerViewData(MainActivity.favouriteGiphyList);
        return view;
    }

    public static void loadRecyclerViewData(List<GiphyModule> favouriteGiphyList) {
        recyclerViewFavourites = (RecyclerView) view.findViewById(R.id.pref_recycler_view);
        recyclerViewFavourites.setHasFixedSize(true);
        recyclerViewFavourites.setLayoutManager(new GridLayoutManager(view.getContext(),3));

        adapter = new AdaptorRecyclerViewFavourite(favouriteGiphyList,view.getContext().getApplicationContext());
        recyclerViewFavourites.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


}
