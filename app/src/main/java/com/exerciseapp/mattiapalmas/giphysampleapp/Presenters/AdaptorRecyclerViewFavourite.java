package com.exerciseapp.mattiapalmas.giphysampleapp.Presenters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.exerciseapp.mattiapalmas.giphysampleapp.Modules.GiphyModule;
import com.exerciseapp.mattiapalmas.giphysampleapp.R;
import com.exerciseapp.mattiapalmas.giphysampleapp.Views.MainActivity;

import java.io.IOException;
import java.util.List;

/**
 * Created by mattia palmas on 2018-01-19.
 */

public class AdaptorRecyclerViewFavourite extends RecyclerView.Adapter<AdaptorRecyclerViewFavourite.ViewHolder> {

    List<GiphyModule> giphy;
    private Context context;
    private RecyclerViewClickListener mListener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_pref_recycler_view,parent,false);
        return new ViewHolder(view, mListener);
    }

    public AdaptorRecyclerViewFavourite(List<GiphyModule> giphy, Context context, RecyclerViewClickListener listener) {
        this.giphy = giphy;
        this.context = context;
        mListener = listener;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final GiphyModule listItem = giphy.get(position);


        String x = "<!DOCTYPE html><html><body><img src=\""+ listItem.getGifUrl() +"\" width=\"250px\" height=\"150px\"></body></html>";
        holder.git_pref_image_view.loadData(x, "text/html", "utf-8");
    }

    @Override
    public int getItemCount() {
        if (giphy == null){
            return 0;
        } else {
            return giphy.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private WebView git_pref_image_view;
        private RecyclerViewClickListener mListener;

        public ViewHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            git_pref_image_view = itemView.findViewById(R.id.git_pref_image_view);
            mListener = listener;
        }

        @Override
        public void onClick(View view) {
            try {
                mListener.onClick(view, getAdapterPosition());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
