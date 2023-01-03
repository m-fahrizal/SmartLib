package com.example.smartlib;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class JournalList extends AppCompatActivity {
    private ImageView backHome;
    public LinearLayout JournalR1, JournalRead2, JournalRead3, JournalRead4, JournalRead5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_list);
        backHome = (ImageView) findViewById(R.id.back_journal1);
        JournalR1 = (LinearLayout) findViewById(R.id.journal1);
        JournalRead2 = (LinearLayout) findViewById(R.id.journal2);
        JournalRead3 = (LinearLayout) findViewById(R.id.journal3);
        JournalRead4 = (LinearLayout) findViewById(R.id.journal4);
        JournalRead5 = (LinearLayout) findViewById(R.id.journal5);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backHomeJournal = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backHomeJournal);
            }
        });
        JournalR1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBook1 = new Intent(getApplicationContext(), JournalDetail1.class);
                startActivity(goBook1);
            }
        });
        JournalRead2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goJournal2 = new Intent(getApplicationContext(), JournalDetail2.class);
                startActivity(goJournal2);
            }
        });
        JournalRead3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goJournal3 = new Intent(getApplicationContext(), JournalDetail3.class);
                startActivity(goJournal3);
            }
        });
        JournalRead4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goJournal4 = new Intent(getApplicationContext(), JournalDetail4.class);
                startActivity(goJournal4);
            }
        });
        JournalRead5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goJournal1 = new Intent(getApplicationContext(), JournalDetail5.class);
                startActivity(goJournal1);
            }
        });
    }
}