package com.example.foodsafety;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.foodsafety.json.business;

import java.util.List;

@Dao
public interface BusinessDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(business business);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertList(business...businesses);

    @Query("SELECT * FROM businesses ORDER BY ID ASC")
    List<business> getAll();

    @Update
    public void update(business business);

    @Update
    public void updateBusinesss(business...business);

    @Delete
    public void delete(business business);

    @Delete
    public void deleteBusinesses(business...businesses);



}
