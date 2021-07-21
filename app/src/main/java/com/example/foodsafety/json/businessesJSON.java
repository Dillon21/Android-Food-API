package com.example.foodsafety.json;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Entity(tableName = "restaurants")
public class businessesJSON {
    @PrimaryKey
    public int ID;

    @ColumnInfo(name = "business_name")
    public String business_name;

    public static class getJson {
        public String json;
        public JSONObject getEst;
        public JSONObject getCol;
        public JSONArray tasksArray;

        /**
         * takes in json respons from api and grabs inner array of products found
         * @param json
         */
        public getJson(String json){
            this.json = json;
        }

        public JSONArray getRestaurants(){

            try {
                JSONObject jsonObject = new JSONObject(json);
                getEst = jsonObject.getJSONObject("FHRSEstablishment");
                getCol = getEst.getJSONObject("EstablishmentCollection");
                tasksArray = getCol.getJSONArray("EstablishmentDetail");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return tasksArray;
        }//CONCAT LATER IN MAIN



    }


}
