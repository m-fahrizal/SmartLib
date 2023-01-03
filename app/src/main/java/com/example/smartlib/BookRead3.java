package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BookRead3 extends AppCompatActivity {
    private ImageView backBookList;
    Button read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_read3);
        backBookList = (ImageView) findViewById(R.id.back_bookdetail);
        read = (Button) findViewById(R.id.R_btn_1);

        backBookList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookRead3.this, MyCollectionFragment.class);
                startActivity(intent);
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ViewBook3.class);
                startActivity(intent);
            }
        });
    }
}