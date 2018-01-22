package com.exerciseapp.mattiapalmas.giphysampleapp.Modules;

import com.exerciseapp.mattiapalmas.giphysampleapp.Views.MainActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * Created by mattia palmas on 2018-01-22.
 */

public class SaveFavouriteGiphyInternalStorage implements Serializable{
    public static List<GiphyModule> favouriteGiphyList = MainActivity.favouriteGiphyList;
    static SaveFavouriteGiphyInternalStorage instance =null;

    public static SaveFavouriteGiphyInternalStorage getInstance(){
        if( instance == null )
            instance = new SaveFavouriteGiphyInternalStorage();
        return instance;
    }

    public static void saveData(SaveFavouriteGiphyInternalStorage instance){
        ObjectOutput out;
        try {
            out = new ObjectOutputStream(new FileOutputStream("appSaveState.data"));
            out.writeObject(instance);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SaveFavouriteGiphyInternalStorage loadData(){
        ObjectInput in;
        SaveFavouriteGiphyInternalStorage ss=null;
        try {
            in = new ObjectInputStream(new FileInputStream("appSaveState.data"));
            ss=(SaveFavouriteGiphyInternalStorage) in.readObject();
            in.close();
        } catch (Exception e) {e.printStackTrace();}
        return ss;
    }
}
