package com.example.smartlib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class BookAfter2 extends AppCompatActivity {
    private ImageView backBookList;
    Button read1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_after2);
        backBookList = (ImageView) findViewById(R.id.back_bookdetail);
        read1 = (Button) findViewById(R.id.borrowbtn);

        backBookList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backHomeBook = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backHomeBook);
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