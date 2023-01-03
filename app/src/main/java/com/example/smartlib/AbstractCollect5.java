package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AbstractCollect5 extends AppCompatActivity {
    private ImageView back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstract_collect5);
        back = (ImageView) findViewById(R.id.backJ5);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backHomeBook = new Intent(getApplicationContext(), JournalRead5.class);
                startActivity(backHomeBook);
            }
        });
    }
}