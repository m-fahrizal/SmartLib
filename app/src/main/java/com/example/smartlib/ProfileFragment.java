package com.example.smartlib;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {
    Button editProfile, signOut;
    LinearLayout changePass, history;
    TextView nameProfile;
    FirebaseUser user;
    String userID, name;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        changePass = (LinearLayout) view.findViewById(R.id.change_pass);
        history = (LinearLayout) view.findViewById(R.id.history);
        signOut = (Button) view.findViewById(R.id.signout_button);
        nameProfile = view.findViewById(R.id.nameprofile);

        user = FirebaseAuth.getInstance().getCurrentUser();
        userID = user.getUid();
        reference = FirebaseDatabase.getInstance("https://smartlibfix-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Users").child(userID);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userGreeting = snapshot.getValue(User.class);

                if (userGreeting != null) {
                    name = userGreeting.name;
                    nameProfile.setText("" + name);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });
        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openChangePass = new Intent(getActivity(), ChangePassword.class);
                startActivity(openChangePass);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openHistory = new Intent(getActivity(), History.class);
                startActivity(openHistory);
            }
        });
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent exitApp = new Intent(getActivity(), SignOut.class);
                startActivity(exitApp);
            }
        });
        return view;
    }
}