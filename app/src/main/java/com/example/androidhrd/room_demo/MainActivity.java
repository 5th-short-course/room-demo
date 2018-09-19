package com.example.androidhrd.room_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidhrd.room_demo.data.local.room.dao.BookDao;
import com.example.androidhrd.room_demo.data.local.room.dao.UserDao;
import com.example.androidhrd.room_demo.data.local.room.database.MyDatabase;
import com.example.androidhrd.room_demo.data.local.room.entity.Book;
import com.example.androidhrd.room_demo.data.local.room.entity.User;
import com.example.androidhrd.room_demo.data.local.room.entity.UserBooks;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyDatabase database;
    private UserDao dao;
    private BookDao bookDao;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get database and use dao object
        database=MyDatabase.getInstance(this);
        dao=database.getUserDao();
        bookDao=database.getBookDao();
        tvResult=findViewById(R.id.result);
    }

    public void onSave(View view) {
        User user =new User();
        user.name="raksey";
        user.dob="1995-02-01";
        user.gender="male";
        try{
            //save user
            dao.add(user);
            Toast.makeText(this, "saved", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "cannot save", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }


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

    public void addBooks(){
        List<Book> books=new ArrayList<>();
        for(int i=0; i<10;i++){
            books.add(new Book(1,"Java advanced " +i,"Java advanced","2018-09-16"));
        }
        bookDao.addBooks(books);
    }
    public void getAllBooks(){
        List<Book> books=bookDao.getAll();
        for(Book book: books){
            Log.e(TAG, "getAllBooks: "+ book.toString() );
        }
    }

    private static final String TAG = "MainActivity";

    public void onAddBooks(View view) {
        addBooks();
        Toast.makeText(this, "save books successfully", Toast.LENGTH_SHORT).show();
    }

    public void onGetAllBooks(View view) {
        getAllBooks();
    }

    public void onGetAllUserBooks(View view) {
        getAllUserBooks();
    }

    private void getAllUserBooks() {
        List<UserBooks> userBooks=dao.getUserBooks();
        for(UserBooks userBook : userBooks){
            Log.e(TAG, "getAllUserBooks: "+ userBook.toString() );
        }
    }


}
