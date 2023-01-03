package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BookList extends AppCompatActivity {
    private ImageView backHome;
    private LinearLayout book1, book2, book3, book4, book5, book6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        backHome = (ImageView) findViewById(R.id.back_book1);
        book1 = (LinearLayout) findViewById(R.id.bookList1);
        book2 = (LinearLayout) findViewById(R.id.bookList2);
        book3 = (LinearLayout) findViewById(R.id.bookList3);
        book4 = (LinearLayout) findViewById(R.id.bookList4);
        book5 = (LinearLayout) findViewById(R.id.bookList5);
        book6 = (LinearLayout) findViewById(R.id.bookList6);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backHomeBook = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backHomeBook);
            }
        });
        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBook1 = new Intent(getApplicationContext(), BookDetail1.class);
                startActivity(goBook1);
            }
        });
        book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBook2 = new Intent(getApplicationContext(), BookDetail2.class);
                startActivity(goBook2);
            }
        });
        book3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBook3 = new Intent(getApplicationContext(), BookDetail3.class);
                startActivity(goBook3);
            }
        });
        book4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBook4 = new Intent(getApplicationContext(), BookDetail4.class);
                startActivity(goBook4);
            }
        });
        book5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBook5 = new Intent(getApplicationContext(), BookDetail5.class);
                startActivity(goBook5);
            }
        });
        book6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBook6 = new Intent(getApplicationContext(), BookDetail6.class);
                startActivity(goBook6);
            }
        });

    }
}