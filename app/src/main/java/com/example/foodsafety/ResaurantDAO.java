package com.example.foodsafety;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ResaurantDAO {
    @Query("SELECT * FROM restaurants")
    List<business> getAll();

}
