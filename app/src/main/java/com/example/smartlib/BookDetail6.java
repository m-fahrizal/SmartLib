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

public class BookDetail6 extends AppCompatActivity {
    private ImageView backBookList;
    Button read1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail6);
        backBookList = (ImageView) findViewById(R.id.back_bookdetail);
        read1 = (Button) findViewById(R.id.R_btn_1);

        backBookList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        read1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                FirebaseFirestore db = FirebaseFirestore.getInstance();

                HashMap<String, Object> bookdata = new HashMap<>();
                bookdata.put("namaBuku", "Learning PHP, MySQL and JavaScript");
                bookdata.put("penulis", "Robin Nixon");
                bookdata.put("tahun", "2021");
                bookdata.put("idBuku", 6);
                bookdata.put("idUser", user.getUid());

                db.collection("pinjam")
                        .document("pinjam")
                        .collection("peminjaman"+user.getUid())
                        .document("pinjam-6")
                        .set(bookdata)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });

                Intent goBook1 = new Intent(getApplicationContext(), BorrowJournal.class);
                startActivity(goBook1);
            }
        });
    }
}