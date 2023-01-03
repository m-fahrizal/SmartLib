package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class JournalRead1 extends AppCompatActivity {
    private ImageView backBookList;
    Button read;
    TextView more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_read1);
        backBookList = (ImageView) findViewById(R.id.back_bookdetail);
        read = (Button) findViewById(R.id.R_btn_1);
        more = (TextView) findViewById(R.id.seemoreJ1);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seeMore = new Intent(getApplicationContext(), AbstractCollect1.class);
                startActivity(seeMore);
            }
        });

        backBookList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ViewJournal.class);
                startActivity(intent);
            }
        });
    }
}