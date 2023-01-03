package com.example.smartlib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    TextView btnregister;
    Button btnlogin;
    EditText inputEmail, inputPassword;
    String email, password;
    boolean passwordVisible;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnregister = (TextView) findViewById(R.id.btn_regist2);
        btnlogin = (Button) findViewById(R.id.R_btn_1);
        inputEmail = findViewById(R.id.edt_email);
        inputPassword = findViewById(R.id.edt_password);
        mAuth = FirebaseAuth.getInstance();

        inputPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if (motionEvent.getRawX() >= inputPassword.getRight()-inputPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = inputPassword.getSelectionEnd();
                        if (passwordVisible){
                            // set drawable image here
                            inputPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_visibility_off_24, 0);
                            // for hide password
                            inputPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        }else {
                            // set drawable image here
                            inputPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_eye, 0);
                            // for show password
                            inputPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        inputPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent moveregist = new Intent(getApplicationContext(), register.class);
                startActivity(moveregist);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checklogin();
            }
        });
    }

    private void checklogin() {
        email = inputEmail.getText().toString();
        password = inputPassword.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(login.this, "Login Successful", Toast.LENGTH_LONG).show();
                            Intent moveHome = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(moveHome);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(login.this, "Login Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
