package com.example.foodsafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.foodsafety.json.business;
import com.example.foodsafety.json.getBuilder;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    Button buttonAberdeen;
    Button buttonGlasgow;
    Button buttonDundee;
    Button buttonEdinburgh;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAberdeen = findViewById(R.id.button);

        buttonAberdeen.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View view){
                setAberdeen(view);
            }
        }));
    }



    public void setGlasgow(View view){
        Intent intent = new Intent(this, DisplayBusinessActivity.class){

        };
    }

    public void setAberdeen(View view){
        Intent intent = new Intent(this,DisplayBusinessActivity.class);
            intent.putExtra(EXTRA_MESSAGE,"/^/^/rating/1/760/pass/1/1/1500/json");
            startActivity(intent);

    }

    public void setEdinburgh(View view){

    }

    public void setDundee(View view){

    }

}


