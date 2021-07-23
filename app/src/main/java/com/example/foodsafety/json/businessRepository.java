package com.example.foodsafety.json;

import android.content.Context;
import android.util.Log;


import com.example.foodsafety.BusinessDao;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class businessRepository {

    private BusinessDao businessDao;

    public static businessRepository INSTANCE;

    private Context context;

    public static businessRepository getRepository(Context context) {
        if (INSTANCE == null) {
            synchronized (businessRepository.class) {
                INSTANCE = new businessRepository();
                INSTANCE.context = context;
                businessDatabase db = businessDatabase.getDatabase(context);
                INSTANCE.businessDao = db.businessDao();
            }
        }
        return INSTANCE;
    }

    //store business in database
    public void storeBusiness(business business){
        businessDao.insert(business);
    }

    //delete business from database
    public void deleteBusiness(business business){
        businessDao.delete(business);
    }

    //get all businesses from databse (NOT USED)
    public ArrayList<business> getAllBusinesses(){
        return (ArrayList) businessDao.getAll();
    }

    //parses the JSON from the OKHTTP response into usable objects
    public static ArrayList<business> getJson(String response) {
        String json = response;
        JSONObject getEst;
        JSONObject getCol;
        JSONArray tasksArray = new JSONArray();

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
                    //breaking down JSON objects
                    JSONObject object = tasksArray.getJSONObject(i);
                    business.setID((Integer.parseInt(object.getString("FHRSID"))));
                    business.setBusiness_name(object.getString("BusinessName"));
                    business.setRating(object.getString("RatingValue"));
                    JSONObject geocode = object.getJSONObject("Geocode");
                    //testing if ojects are being taken
                    Log.d("geocode", String.valueOf(geocode) );
                    business.setLongitude(geocode.getString("Longitude"));
                    business.setLatitude(geocode.getString("Latitude"));
                    //test geocode json
                    Log.d("location", "long " + business.getLongitude() + " lat " + business.getLatitude());

                    //add business
                    businesses.add(business);
                } catch(JSONException e){
                    e.printStackTrace();
                }
            }
            return businesses;
        }//CONCAT LATER IN MAIN

        //test length of JSON ARRAY (NOT USED)
        public String getBusinessesString(String myResponse) {

            String stringJson = "";
            Log.d("please", stringJson);
            Log.d("size", "length of array" + String.valueOf(myResponse.length()));

            return stringJson;
        }



}
