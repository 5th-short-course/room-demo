package com.example.androidhrd.room_demo.data.local.room.entity;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.lang.annotation.Retention;
import java.util.List;

public class UserBooks {

    @Embedded
    public User user;
    @Relation(parentColumn = "id",entityColumn = "user_id")
    public List<Book> books;
    @Override
    public String toString() {
        return "UserBooks{" +
                "user=" + user +
                ", books=" + books +
                '}';
    }
}
