package com.example.foodsafety;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.view.View;

import com.example.foodsafety.json.business;
import com.example.foodsafety.json.businessRepository;
import com.example.foodsafety.json.getBuilder;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DisplayBusinessActivity extends AppCompatActivity {

    getBuilder get;
    String input = "/^/^/rating/1/760/pass/1/1/1500/json";
    public static TextView test;


    public static TextView businessName;
    public static TextView businessRating;
    public static Long lat;
    public static Long lon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business_recycler);

        //List<business> businesses = businessRepository.getRepository(getApplicationContext()).getAllBusinesses();



        Intent intent = getIntent();




        OkHttpClient client = new OkHttpClient();
        get = new getBuilder(input);
        //get = new getProducts(test.toString());
        Request request = get.getRequest();



        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
                Log.d("fail",request.url().toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    DisplayBusinessActivity.this.runOnUiThread(() -> {
                        //test.setText(myResponse);
                        Log.d("test", myResponse);
                        ArrayList<business> list = new ArrayList<>();

                        list = businessRepository.getJson(myResponse);
                        business test = list.get(0);
                        int id = test.getID();
                        Log.d("test", String.valueOf(list.size()));


                        RecyclerView recyclerView = findViewById(R.id.rv_Businesses);
                        RecyclerView.Adapter adapter = new BusinessAdapterView(getApplicationContext(),list);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


                    });
                }
            }
        });



    }

    public void getBusinessDetails(ArrayList<business> list, int index){
        business business = list.get(index);

    }

    //public ArrayList<business>



}