package com.example.androidhrd.room_demo.data.local.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "users", indices = {@Index(value = {"name"},unique = true)})
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;
    //@ColumnInfo(name = "fist_name")
    public String name;
    public String gender;
    public String dob;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
