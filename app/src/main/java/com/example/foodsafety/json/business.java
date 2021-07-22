package com.example.foodsafety.json;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Entity(tableName = "businesses")
public class business {

    @NonNull
    @PrimaryKey
    public int ID;

    @ColumnInfo(name = "business_name")
    public String business_name;

    @ColumnInfo(name = "rating")
    public String rating;



    public void setID(int id){
        this.ID = id;
    }

    public void setBusiness_name(String name){
        this.business_name = name;
    }

    public void setRating(String rating){
        this.rating = rating;
    }

    public int getID() {
        return ID;
    }

    public String getBusiness_name(){
        return business_name;
    }

    public String getRating(){
        return rating;
    }
}

