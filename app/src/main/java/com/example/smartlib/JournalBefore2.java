package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class JournalBefore2 extends AppCompatActivity {
    private Button Login;
    private ImageView backBookList;
    TextView more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_before2);
        Login = (Button) findViewById(R.id.R_btn_1);
        backBookList = (ImageView) findViewById(R.id.back_bookdetail);
        more = (TextView) findViewById(R.id.seemoreJ2);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seeMore = new Intent(getApplicationContext(), AbstractBefore2.class);
                startActivity(seeMore);
            }
        });

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