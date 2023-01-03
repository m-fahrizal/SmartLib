package com.example.smartlib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class JournalDetail2 extends AppCompatActivity {
    private ImageView backJournalList;
    TextView seeMore;
    Button btnBorrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_detail2);
        seeMore = (TextView) findViewById(R.id.seemoreJ2);
        backJournalList = (ImageView) findViewById(R.id.back_bookdetail);
        btnBorrow = (Button) findViewById(R.id.R_btn_1);

        seeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openAbstract1 = new Intent(getApplicationContext(), JournalAbstract2.class);
                startActivity(openAbstract1);
            }
        });

        backJournalList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnBorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                FirebaseFirestore db = FirebaseFirestore.getInstance();

                HashMap<String, Object> bookdata = new HashMap<>();
                bookdata.put("namaBuku", "Tool Support to Automate Transformations from SBVR to UML Use Case Diagram");
                bookdata.put("penulis", "Imane Essebaa and Salima Chantit");
                bookdata.put("tahun", "2018");
                bookdata.put("idBuku", 8);
                bookdata.put("idUser", user.getUid());

                db.collection("pinjam")
                        .document("pinjam")
                        .collection("peminjaman"+user.getUid())
                        .document("pinjam-8")
                        .set(bookdata)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                            }
                        });
                Intent borrow = new Intent(getApplicationContext(), BorrowJournal.class);
                startActivity(borrow);
            }
        });
    }
}