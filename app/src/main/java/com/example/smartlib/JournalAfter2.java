package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class JournalAfter2 extends AppCompatActivity {
    private ImageView backBookList;
    Button read1;
    TextView more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_after2);
        backBookList = (ImageView) findViewById(R.id.back_bookdetail);
        read1 = (Button) findViewById(R.id.borrowj2);
        more = (TextView) findViewById(R.id.seemoreJ2);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seeMore = new Intent(getApplicationContext(), AbstractAfter2.class);
                startActivity(seeMore);
            }
        });

        backBookList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        read1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBook1 = new Intent(getApplicationContext(), BorrowJournal.class);
                startActivity(goBook1);
            }
        });
    }
}