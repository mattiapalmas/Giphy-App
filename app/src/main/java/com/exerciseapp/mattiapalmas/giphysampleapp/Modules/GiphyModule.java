package com.exerciseapp.mattiapalmas.giphysampleapp.Modules;

import java.io.Serializable;

/**
 * Created by mattia palmas on 2018-01-18.
 */

public class GiphyModule implements Serializable {
    private String gifUrl;
    private Boolean isFavourite;

    public GiphyModule(String gifUrl, boolean isFavourite) {
        this.gifUrl = gifUrl;
        this.isFavourite = isFavourite;
    }


    public String getGifUrl() {
        return gifUrl;
    }

    public void setGifUrl(String gifUrl) {
        this.gifUrl = gifUrl;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
    }
}
