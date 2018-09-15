package com.example.androidhrd.room_demo.data.local.room.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.androidhrd.room_demo.data.local.room.dao.UserDao;
import com.example.androidhrd.room_demo.data.local.room.entity.User;

@Database(version = 1,entities = {User.class} )
public abstract class MyDatabase extends RoomDatabase{
    private static final String DB_NAME="my_db";
    public abstract UserDao getUserDao();

    public static MyDatabase getInstance(Context context){
        return Room.databaseBuilder(context,MyDatabase.class,DB_NAME)
                .allowMainThreadQueries()
                .build();
    }
}
