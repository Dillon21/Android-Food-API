package com.example.foodsafety.json;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.foodsafety.BusinessDao;

@Database(entities = {business.class}, version = 1)
public abstract class BusinessDatabase extends RoomDatabase {

    public abstract BusinessDao businessDao();

    public static BusinessDatabase INSTANCE;

    public static BusinessDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized(BusinessDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BusinessDatabase.class, "business_database")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
