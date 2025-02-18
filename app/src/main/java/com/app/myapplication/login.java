package com.app.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private EditText inputPass1, inputUser1;
    private Button btnlogin;

    // Set your valid username & password here
    private final String VALID_USERNAME = "tuhina";
    private final String VALID_PASSWORD = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Initialize UI elements
        inputUser1 = findViewById(R.id.inputUser1);
        inputPass1 = findViewById(R.id.inputPass1);
        btnlogin = findViewById(R.id.btnlogin);

        // Sign-up button click (redirects to Register Page)
        TextView btnSignup = findViewById(R.id.signup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login.this, register.class));
            }
        });

        // Login Button Click
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateLogin();
            }
        });
    }

    private void validateLogin() {
        String username = inputUser1.getText().toString().trim();
        String password = inputPass1.getText().toString().trim();

        // Check if username & password match
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();

            // Redirect to Home Page or Dashboard
            Intent intent = new Intent(login.this, HomeActivity.class);
            startActivity(intent);
            finish(); // Closes the login activity
        } else {
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }
    }
}
