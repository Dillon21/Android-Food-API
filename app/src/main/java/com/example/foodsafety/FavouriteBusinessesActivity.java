package com.example.foodsafety;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import com.example.foodsafety.json.business;
import com.example.foodsafety.json.businessRepository;

import java.util.ArrayList;
import java.util.List;

public class FavouriteBusinessesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_businesses);


        //Get list stored in database
        ArrayList<business> list = businessRepository.getRepository(getApplicationContext()).getAllBusinesses();

        //input database into recycler view
        RecyclerView recyclerView = findViewById(R.id.rv_favourites);
        RecyclerView.Adapter adapter = new FavouritesAdapterView(getApplicationContext(),list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


    }
}