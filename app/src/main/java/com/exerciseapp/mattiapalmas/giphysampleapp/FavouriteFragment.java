package com.exerciseapp.mattiapalmas.giphysampleapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavouriteFragment extends Fragment {

    static View view;
    static RecyclerView recyclerView;
    static RecyclerView.Adapter adapter;

    public FavouriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favourite, container, false);
        loadRecyclerViewData();
        return view;
    }

    public static void loadRecyclerViewData() {
        recyclerView = (RecyclerView) view.findViewById(R.id.pref_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),3));

        adapter = new AdaptorRecyclerViewFavourite(AdaptorRecycleViewGiphy.favouriteGiphyList,view.getContext().getApplicationContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


}
