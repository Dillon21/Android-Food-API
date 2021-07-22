package com.example.foodsafety.json;

import android.content.Context;
import android.os.Build;
import android.util.Log;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class businessRepository {

    public static businessRepository INSTANCE;

    private Context context;

    public static businessRepository getRepository(Context context) {
        if (INSTANCE == null) {
            synchronized (businessRepository.class) {
                INSTANCE = new businessRepository();
                INSTANCE.context = context;
            }
        }
        return INSTANCE;
    }

    //public business getBusiness(String )

    public static ArrayList<business> getJson(String response) {
        String json = response;
        JSONObject getEst;
        JSONObject getCol;
        JSONArray tasksArray = new JSONArray();

        /**
         * takes in json respons from api and grabs inner array of products found
         * @param json
         */
        /*public getJson(String json){
            this.json = json;
        }*/



            ArrayList<business> businesses = new ArrayList<>();
            try {
                JSONObject jsonObject = new JSONObject(json);
                getEst = jsonObject.getJSONObject("FHRSEstablishment");
                getCol = getEst.getJSONObject("EstablishmentCollection");
                tasksArray = getCol.getJSONArray("EstablishmentDetail");

            } catch (JSONException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < tasksArray.length();i++){
                business business = new business();
                try {

                    JSONObject object = tasksArray.getJSONObject(i);
                    business.setID((Integer.parseInt(object.getString("FHRSID"))));
                    business.setBusiness_name(object.getString("BusinessName"));
                    business.setRating(object.getString("RatingValue"));

                    businesses.add(business);
                } catch(JSONException e){
                    e.printStackTrace();
                }
            }
            return businesses;
        }//CONCAT LATER IN MAIN

        public String getBusinessesString(String myResponse) {

            String stringJson = "";
            Log.d("please", stringJson);
            Log.d("size", "length of array" + String.valueOf(myResponse.length()));

            return stringJson;
        }



}