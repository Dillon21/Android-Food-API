package com.example.foodsafety;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "restaurants")
public class business {
    @PrimaryKey
    public int ID;

    @ColumnInfo(name = "business_name")
    public String business_name;

}
