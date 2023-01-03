package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class JournalAfter1 extends AppCompatActivity {
    ImageView backBookList;
    Button borrow;
    TextView more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_detail1);
        backBookList = (ImageView) findViewById(R.id.back_bookdetail);
        borrow = (Button) findViewById(R.id.R_btn_1);
        more = (TextView) findViewById(R.id.seemoreJ1);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seeMore = new Intent(getApplicationContext(), AbstractAfter1.class);
                startActivity(seeMore);
            }
        });

        backBookList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        borrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBook1 = new Intent(getApplicationContext(), BorrowJournal.class);
                startActivity(goBook1);
            }
        });
    }
}