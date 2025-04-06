package com.example.mentalhealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpPage extends AppCompatActivity {

    EditText textEmail, pass, cpass;
    Button signup, login;
    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance(); // ✅ moved here
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            startActivity(new Intent(getApplicationContext(), HomePage.class));
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        mAuth = FirebaseAuth.getInstance();

        textEmail = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        cpass = findViewById(R.id.cpassword);
        signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = textEmail.getText().toString().trim();
                String password = pass.getText().toString().trim();
                String confirmPassword = cpass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(SignUpPage.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(SignUpPage.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(SignUpPage.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignUpPage.this, "Account Created", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), HomePage.class));
                                } else {
                                    Exception e = task.getException();
                                    if (e != null) {
                                        Toast.makeText(SignUpPage.this, "Sign-up Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                                        e.printStackTrace(); // This prints the stack trace in Logcat
                                    } else {
                                        Toast.makeText(SignUpPage.this, "Unknown sign-up error", Toast.LENGTH_LONG).show();
                                    }
                                }


                            }
                        });
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }
}
