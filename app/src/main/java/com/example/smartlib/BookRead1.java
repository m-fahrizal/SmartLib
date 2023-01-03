package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class BookRead1 extends AppCompatActivity {
    private ImageView backBookList;
    Button read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_read1);
        backBookList = (ImageView) findViewById(R.id.back_bookdetail);
        read = (Button) findViewById(R.id.R_btn_1);

        backBookList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ViewBook.class);
                startActivity(intent);
            }
        });
    }
}