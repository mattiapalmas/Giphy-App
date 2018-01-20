package com.exerciseapp.mattiapalmas.giphysampleapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by mattia palmas on 2018-01-18.
 */

public class AdaptorRecycleView  extends RecyclerView.Adapter<AdaptorRecycleView.ViewHolder>{

    private List<GiphyModule> listItems;
    private Context context;

    public AdaptorRecycleView(List<GiphyModule> listItems, Context applicationContext) {
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
    public void onBindViewHolder(ViewHolder holder, int position) {
        GiphyModule listItem = listItems.get(position);

        String x = "<!DOCTYPE html><html><body><img src=\""+ listItem.getGifUrl() +"\" width=\"250px\" height=\"150px\"></body></html>";

        holder.gitImageView.loadData(x, "text/html", "utf-8");

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

            starPrefBtn.setTag("new");
            starPrefBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (view.getTag().equals("R.drawable.starsilver") || view.getTag().equals("new")){
                        Toast.makeText(view.getContext(), "Turn into yellow", Toast.LENGTH_SHORT).show();
                        view.setBackgroundResource(R.drawable.stargold);
                        view.setTag("R.drawable.stargold");
                    }
                    else {
                        Toast.makeText(view.getContext(), "Turn into grey", Toast.LENGTH_SHORT).show();
                        view.setBackgroundResource(R.drawable.stargrey);
                        view.setTag("R.drawable.starsilver");
                    }
                }
            });
        }
    }
}
