package com.example.androidhrd.room_demo.data.local.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.androidhrd.room_demo.data.local.room.entity.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(User ... users);
    @Insert
    void add(User user);
    @Insert
    void add(List<User>  users);
    @Delete
    void remove(User user);
    @Update
    void edit(User user);
    @Query("SELECT * FROM USERS order by id asc")
    List<User> getAll();
    @Query("SELECT * FROM USERS WHERE id= :id")
    User getUserById(int id);
}
