package com.exerciseapp.mattiapalmas.giphysampleapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by mattia palmas on 2018-01-18.
 */

public class AdaptorRecycleViewGiphy extends RecyclerView.Adapter<AdaptorRecycleViewGiphy.ViewHolder>{

    private List<GiphyModule> listItems;
    public static List<GiphyModule> favouriteGiphyList;
    private Context context;

    public AdaptorRecycleViewGiphy(List<GiphyModule> listItems, Context applicationContext) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_recycler_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final GiphyModule listItem = listItems.get(position);

        String x = "<!DOCTYPE html><html><body><img src=\""+ listItem.getGifUrl() +"\" width=\"250px\" height=\"150px\"></body></html>";
        holder.gitImageView.loadData(x, "text/html", "utf-8");
        holder.starPrefBtn.setTag(position);

        favouriteGiphyList = new ArrayList<>();


        holder.starPrefBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!listItem.isFavourite()){
                        view.setBackgroundResource(R.drawable.stargold);
                        favouriteGiphyList.add(listItem);
                    listItem.setFavourite(true);
                }
                else {
                    view.setBackgroundResource(R.drawable.stargrey);
                    favouriteGiphyList.remove(listItem);
                    listItem.setFavourite(false);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public WebView gitImageView;
        public ImageButton starPrefBtn;

        public ViewHolder(View itemView) {
            super(itemView);
            gitImageView = itemView.findViewById(R.id.git_image_view);
            starPrefBtn = itemView.findViewById(R.id.pref_star_btn);


        }
    }
}
