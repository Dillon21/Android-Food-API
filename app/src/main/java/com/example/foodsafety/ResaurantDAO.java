package com.example.foodsafety;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.foodsafety.json.business;

import java.util.List;

@Dao
public interface ResaurantDAO {
    @Query("SELECT * FROM ")
    List<business> getAll();

}
