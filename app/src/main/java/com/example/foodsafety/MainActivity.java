package com.example.foodsafety;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    getBuilder get;
    String input = "enhanced-search/en-GB/^/^/Rating/0/760/1/2/json";
    public static TextView test;
    public JSONObject getRestaurants;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    MainActivity.this.runOnUiThread(() -> {
                        //test.setText(myResponse);
                        Log.d("test", myResponse);



                        productJson pJ = new productJson(myResponse);
                        Log.d("json", pJ.toString());
                        JSONArray jsonArray = new JSONArray();
                        jsonArray = pJ.getRestaurants();
                        Log.d("please", jsonArray.toString());


                    });
                }
            }
        });


    }
}


