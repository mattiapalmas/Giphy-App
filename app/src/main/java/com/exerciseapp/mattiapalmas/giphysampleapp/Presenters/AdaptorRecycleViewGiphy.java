package com.exerciseapp.mattiapalmas.giphysampleapp.Presenters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.exerciseapp.mattiapalmas.giphysampleapp.Modules.GiphyModule;
import com.exerciseapp.mattiapalmas.giphysampleapp.R;
import com.exerciseapp.mattiapalmas.giphysampleapp.Views.MainActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mattia palmas on 2018-01-18.
 */

public class AdaptorRecycleViewGiphy extends RecyclerView.Adapter<AdaptorRecycleViewGiphy.ViewHolder>{

    private RecyclerViewClickListener mListener;
    private List<GiphyModule> listItems;
    private GiphyModule listItem;

    private Context context;

    public AdaptorRecycleViewGiphy(List<GiphyModule> listItems, Context applicationContext, RecyclerViewClickListener listener) {
        this.listItems = listItems;
        this.context = applicationContext;
        mListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_recycler_view,parent,false);

        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        listItem = listItems.get(position);

        String x = "<!DOCTYPE html><html><body><img src=\""+ listItem.getGifUrl() +"\" width=\"250px\" height=\"150px\"></body></html>";
        holder.gitImageView.loadData(x, "text/html", "utf-8");

        if (listItem.isFavourite()){
            holder.starPrefBtn.setBackgroundResource(R.drawable.stargold);
        }
        else {
            holder.starPrefBtn.setBackgroundResource(R.drawable.stargrey);
        }
    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private RecyclerViewClickListener mListener;
        public WebView gitImageView;
        public ImageButton starPrefBtn;

        public ViewHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            gitImageView = itemView.findViewById(R.id.git_image_view);
            starPrefBtn = itemView.findViewById(R.id.pref_star_btn);

            mListener = listener;
            starPrefBtn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }
}
