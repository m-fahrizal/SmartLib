package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BookBefore2 extends AppCompatActivity {
    private Button Login;
    private ImageView backBookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_before2);
        Login = (Button) findViewById(R.id.R_btn_1);
        backBookList = (ImageView) findViewById(R.id.back_bookdetail);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveLogin = new Intent(getApplicationContext(), login.class);
                startActivity(moveLogin);
            }
        });

        backBookList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backHomeBook = new Intent(getApplicationContext(), HomeBefore.class);
                startActivity(backHomeBook);
            }
        });
    }
}