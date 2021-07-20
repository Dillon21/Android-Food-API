package com.example.foodsafety;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class productJson {
    public String json;
    public JSONObject getEst;
    public JSONObject getCol;
    public JSONArray tasksArray;

    /**
     * takes in json respons from api and grabs inner array of products found
     * @param json
     */
    public productJson(String json){
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
    }

    /**
     * gets item object containing name field for the product searched
     * @return

    public JSONObject getProductName(){
        try {
            JSONObject jsonObject = new JSONObject(json);
            getItems = jsonObject.getJSONObject("items");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return getItems;
    }
     */

}
