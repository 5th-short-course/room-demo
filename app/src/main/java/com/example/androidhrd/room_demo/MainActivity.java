package com.example.androidhrd.room_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidhrd.room_demo.data.local.room.dao.UserDao;
import com.example.androidhrd.room_demo.data.local.room.database.MyDatabase;
import com.example.androidhrd.room_demo.data.local.room.entity.User;

public class MainActivity extends AppCompatActivity {

    private MyDatabase database;
    private UserDao dao;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get database and use dao object
        database=MyDatabase.getInstance(this);
        dao=database.getUserDao();
        tvResult=findViewById(R.id.result);
    }

    public void onSave(View view) {
        User user =new User();
        user.name="data";
        user.dob="1995-02-01";
        user.gender="male";
        //save user
        dao.add(user);
        Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
    }

    public void onUpdate(View view) {
        User user =new User();
        user.id=2;
        user.name="chan dara";
        user.gender="male";
        user.dob="1996-01-01";
        dao.edit(user);
    }

    public void onGetAll(View view) {
        String data="";
        for(User user: dao.getAll()){
            data=data+ user.toString();
        }

        tvResult.setText(data);
    }

    public void onGetOne(View view) {

    }

    public void onDelete(View view) {
        User user=new User();
        user.id=2;
        dao.remove(user);
    }
}
