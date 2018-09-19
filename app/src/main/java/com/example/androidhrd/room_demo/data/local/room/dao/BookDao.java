package com.example.androidhrd.room_demo.data.local.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.androidhrd.room_demo.data.local.room.entity.Book;
import com.example.androidhrd.room_demo.data.local.room.entity.User;

import java.util.List;

@Dao
public interface BookDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addBooks(List<Book> books);

    @Query("select * from book order by id asc")
    List<Book> getAll();
}
