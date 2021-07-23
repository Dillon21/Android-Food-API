package com.example.foodsafety.json;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

public class getBuilder {
    private Request request;
    public String url;

    //OKHTTP Get request builder
    JSONObject json = new JSONObject();

        public getBuilder(String barcode) {
            url = "https://ratings.food.gov.uk/enhanced-search/en-GB";
            url = url.concat(barcode);

                System.out.println(url);
                request = new Request.Builder()
                        .url(url)
                        .get()
                        .addHeader("x-api-version", "1")
                        .build();
            }


        public Request getRequest(){
            return request;
        }
    }

