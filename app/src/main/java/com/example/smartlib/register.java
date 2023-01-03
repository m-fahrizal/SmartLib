package com.example.smartlib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
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
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity {
    TextView btnlogin;
    EditText inputName, inputPhone, inputEmail, pass1, pass2;
    String name, phone, email, password1, password2;
    boolean passwordVisible;
    Button signup;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        btnlogin = (TextView) findViewById(R.id.btn_login2);
        inputName = findViewById(R.id.edt_fulname);
        inputPhone = findViewById(R.id.edt_phone);
        inputEmail = findViewById(R.id.edt_email);
        pass1 = findViewById(R.id.edt_password);
        pass2 = findViewById(R.id.edt_conf_password);
        signup = (Button)findViewById(R.id.btn_Signup);


        pass1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if (motionEvent.getRawX() >= pass1.getRight()-pass1.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = pass1.getSelectionEnd();
                        if (passwordVisible){
                            // set drawable image here
                            pass1.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_visibility_off_24, 0);
                            // for hide password
                            pass1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        }else {
                            // set drawable image here
                            pass1.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_eye, 0);
                            // for show password
                            pass1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        pass1.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        pass2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if (motionEvent.getRawX() >= pass2.getRight()-pass2.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = pass2.getSelectionEnd();
                        if (passwordVisible){
                            // set drawable image here
                            pass2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_visibility_off_24, 0);
                            // for hide password
                            pass2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        }else {
                            // set drawable image here
                            pass2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_eye, 0);
                            // for show password
                            pass2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        pass2.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bukaRegist = new Intent(getApplicationContext(), login.class);
                startActivity(bukaRegist);
            }
        });
    }

    private void register() {
        name = inputName.getText().toString();
        phone = inputPhone.getText().toString();
        email = inputEmail.getText().toString();
        password1 = pass1.getText().toString();
        password2 = pass2.getText().toString();

        if (name.isEmpty()) {
            inputName.setError("Full name is required");
            inputName.requestFocus();
            return;
        }

        if (phone.isEmpty()) {
            inputPhone.setError("Phone is required");
            inputPhone.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            inputEmail.setError("Email is required");
            inputEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            inputEmail.setError("Please provide valid email");
            inputEmail.requestFocus();
            return;
        }

        if (password1.isEmpty()) {
            pass1.setError("Password is required");
            pass1.requestFocus();
            return;
        }

        if (password1.length() < 6) {
            pass1.setError("Min password should be 6 characters!");
            pass1.requestFocus();
            return;
        }

        if (password2.isEmpty()) {
            pass2.setError("Password confirmation is required");
            pass2.requestFocus();
            return;
        }

        if (!password1.equals(password2)) {
            pass2.setError("Password confirmation didn't match");
            pass2.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password2)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            User user = new User(name, phone, email);

                            FirebaseDatabase.getInstance("https://smartlibfix-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(register.this, "Register Successful", Toast.LENGTH_LONG).show();
                                                Intent moveLogin = new Intent(getApplicationContext(), login.class);
                                                startActivity(moveLogin);
                                            }
                                            else {
                                                Toast.makeText(register.this, "Register Failed", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(register.this, "Register Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
