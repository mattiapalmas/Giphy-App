package com.exerciseapp.mattiapalmas.giphysampleapp.Presenters;

import android.view.View;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by mattia palmas on 2018-01-21.
 */

public interface RecyclerViewClickListener {

    void onClick(View view, int position) throws IOException;
}
