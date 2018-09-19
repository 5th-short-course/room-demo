package com.example.androidhrd.room_demo.data.local.room.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.androidhrd.room_demo.data.local.room.dao.BookDao;
import com.example.androidhrd.room_demo.data.local.room.dao.UserDao;
import com.example.androidhrd.room_demo.data.local.room.entity.Book;
import com.example.androidhrd.room_demo.data.local.room.entity.User;

@Database(version = 2,entities = {User.class, Book.class} )
public abstract class MyDatabase extends RoomDatabase{
    private static final String DB_NAME="my_db";
    public abstract UserDao getUserDao();
    public abstract BookDao getBookDao();
    public static MyDatabase getInstance(Context context){
        return Room.databaseBuilder(context,MyDatabase.class,DB_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }
}
