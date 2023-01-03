package com.example.smartlib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ChangePassword extends AppCompatActivity {
    EditText oldPass, newPass, confPass;
    String oldPassword, password1, password2;
    boolean passwordVisible;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        oldPass = (EditText) findViewById(R.id.et_old_pass);
        newPass = (EditText) findViewById(R.id.et_new_pass);
        confPass = (EditText) findViewById(R.id.et_conf_pass);
        reset = (Button) findViewById(R.id.reset_button);

        oldPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if (motionEvent.getRawX() >= oldPass.getRight()-oldPass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = oldPass.getSelectionEnd();
                        if (passwordVisible){
                            // set drawable image here
                            oldPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_visibility_off_24, 0);
                            // for hide password
                            oldPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        }else {
                            // set drawable image here
                            oldPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_eye, 0);
                            // for show password
                            oldPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        oldPass.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        newPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if (motionEvent.getRawX() >= newPass.getRight()-newPass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = newPass.getSelectionEnd();
                        if (passwordVisible){
                            // set drawable image here
                            newPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_visibility_off_24, 0);
                            // for hide password
                            newPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        }else {
                            // set drawable image here
                            newPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_eye, 0);
                            // for show password
                            newPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        newPass.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        confPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;
                if (motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if (motionEvent.getRawX() >= confPass.getRight()-confPass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = confPass.getSelectionEnd();
                        if (passwordVisible){
                            // set drawable image here
                            confPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_visibility_off_24, 0);
                            // for hide password
                            confPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        }else {
                            // set drawable image here
                            confPass.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_eye, 0);
                            // for show password
                            confPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        confPass.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPass();
            }
        });
    }

    private void resetPass() {
        oldPassword = oldPass.getText().toString();
        password1 = newPass.getText().toString();
        password2 = confPass.getText().toString();

        if (oldPassword.isEmpty()) {
            oldPass.setError("Old password is required");
            oldPass.requestFocus();
            return;
        }

        if (password1.isEmpty()) {
            newPass.setError("New password is required");
            newPass.requestFocus();
            return;
        }

        if (password1.length() < 6) {
            newPass.setError("Min password should be 6 characters!");
            newPass.requestFocus();
            return;
        }

        if (password2.isEmpty()) {
            confPass.setError("New confirmation password is required");
            confPass.requestFocus();
            return;
        }

        if (!password1.equals(password2)) {
            confPass.setError("Password confirmation didn't match");
            confPass.requestFocus();
            return;
        }

        // get current user
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        //re-authenticate the user
        AuthCredential authCredential = EmailAuthProvider.getCredential(user.getEmail(), oldPassword);
        user.reauthenticate(authCredential)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        user.updatePassword(password2)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(ChangePassword.this, "Password Updated", Toast.LENGTH_LONG).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ChangePassword.this, "Change password failed", Toast.LENGTH_LONG).show();
                                    }
                                });
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ChangePassword.this, "Change password failed", Toast.LENGTH_LONG).show();
                    }
                });
    }
}