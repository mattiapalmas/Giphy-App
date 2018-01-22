package com.exerciseapp.mattiapalmas.giphysampleapp.Modules;

/**
 * Created by mattia palmas on 2018-01-18.
 */

public class GiphyModule {
    private String gifUrl;
    private Boolean isFavourite;

    public GiphyModule( String gifUrl, boolean isFavourite){
        this.gifUrl = gifUrl;
        this.isFavourite = isFavourite;
    }


    public String getGifUrl() {
        return gifUrl;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
    }
}
