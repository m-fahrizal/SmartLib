package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeBefore extends AppCompatActivity {
    private Button Login;
    private CardView Card1,Card2, Card3, Card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_before);
        Login = (Button) findViewById(R.id.R_btn_2);
        Card1 = (CardView) findViewById(R.id.card1);
        Card2 = (CardView) findViewById(R.id.card2);
        Card3 = (CardView) findViewById(R.id.card3);
        Card4 = (CardView) findViewById(R.id.card4);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveLogin = new Intent(getApplicationContext(), login.class);
                startActivity(moveLogin);
                }
        });
        Card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveBook1 = new Intent(getApplicationContext(), BookBefore1.class);
                startActivity(moveBook1);
            }
        });
        Card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveBook2 = new Intent(getApplicationContext(), BookBefore2.class);
                startActivity(moveBook2);
            }
        });
        Card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveJournal1 = new Intent(getApplicationContext(), JournalBefore1.class);
                startActivity(moveJournal1);
            }
        });
        Card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveJournal1 = new Intent(getApplicationContext(), JournalBefore2.class);
                startActivity(moveJournal1);
            }
        });
    }
}