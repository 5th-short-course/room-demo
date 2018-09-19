package com.example.androidhrd.room_demo.data.local.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "book",
foreignKeys = @ForeignKey(entity = User.class,
                            parentColumns = "id",
                            childColumns = "user_id")
)
public class Book {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "user_id")
    public int userId;
    public String name;
    public String desc;
    @ColumnInfo(name="import_date")
    public String importDate;

    public Book(int userId, String name, String desc, String importDate) {
        this.userId = userId;
        this.name = name;
        this.desc = desc;
        this.importDate = importDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", importDate='" + importDate + '\'' +
                '}';
    }
}
