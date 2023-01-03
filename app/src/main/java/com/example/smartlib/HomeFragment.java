package com.example.smartlib;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class HomeFragment extends Fragment {
    private TextView greeting;
    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID, name;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView btnseemore1 = view.findViewById(R.id.seemore1);
        TextView btnseemore2 = view.findViewById(R.id.seemore2);
        greeting = view.findViewById(R.id.greeting);
        CardView jurnal1 = view.findViewById(R.id.cardJournal1);
        CardView jurnal2 = view.findViewById(R.id.jurnal2);
        CardView book1 = view.findViewById(R.id.book1) ;
        CardView book2 = view.findViewById(R.id.book2);

        user = FirebaseAuth.getInstance().getCurrentUser();
        userID = user.getUid();
        reference = FirebaseDatabase.getInstance("https://smartlibfix-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Users").child(userID);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userGreeting = snapshot.getValue(User.class);

                if (userGreeting != null) {
                    name = userGreeting.name;
                    greeting.setText("Hi, " + name);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });

        btnseemore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Book = new Intent(getActivity(), BookList.class);
                startActivity(Book);
            }
        });
        btnseemore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Journal = new Intent(getActivity(), JournalList.class);
                startActivity(Journal);
            }
        });
        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Book1 = new Intent(getActivity(), BookDetail1.class);
                startActivity(Book1);
            }
        });
        book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Book2 = new Intent(getActivity(), BookDetail2.class);
                startActivity(Book2);
            }
        });
        jurnal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent journalBook = new Intent(getActivity(), JournalDetail1.class);
                startActivity(journalBook);
            }
        });
        jurnal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent JournalBook2 = new Intent(getActivity(), JournalDetail2.class);
                startActivity(JournalBook2);
            }
        });

        return view;
    }
}