package com.example.foodsafety.json;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.foodsafety.BusinessDao;

@Database(entities = {business.class}, version = 1)
public abstract class businessDatabase extends RoomDatabase {

    public abstract BusinessDao businessDao();

    public static businessDatabase INSTANCE;

    public static businessDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized(businessDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            businessDatabase.class, "business_database")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}
