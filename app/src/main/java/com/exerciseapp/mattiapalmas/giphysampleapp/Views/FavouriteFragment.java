package com.exerciseapp.mattiapalmas.giphysampleapp.Views;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.exerciseapp.mattiapalmas.giphysampleapp.Modules.GiphyModule;
import com.exerciseapp.mattiapalmas.giphysampleapp.Presenters.AdaptorRecyclerViewFavourite;
import com.exerciseapp.mattiapalmas.giphysampleapp.Presenters.RecyclerViewClickListener;
import com.exerciseapp.mattiapalmas.giphysampleapp.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public static void loadRecyclerViewData(List<GiphyModule> favouriteGiphyList) {
        recyclerViewFavourites = (RecyclerView) view.findViewById(R.id.pref_recycler_view);
        recyclerViewFavourites.setHasFixedSize(true);
        recyclerViewFavourites.setLayoutManager(new GridLayoutManager(view.getContext(), 3));


        RecyclerViewClickListener listener = (view, position) -> {
            Toast.makeText(view.getContext(), "listening", Toast.LENGTH_SHORT).show();
            Log.d("listen","listening...");

            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setMessage("You want to delete it from favourites?");

            builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    MainActivity.favouriteGiphyList.remove(position);
                    adapter.notifyDataSetChanged();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });

            AlertDialog dialog = builder.create();
        };
        adapter = new AdaptorRecyclerViewFavourite(favouriteGiphyList, view.getContext().getApplicationContext(), listener);
        recyclerViewFavourites.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_favourite, container, false);

        loadRecyclerViewData(MainActivity.favouriteGiphyList);
        return view;
    }


}
