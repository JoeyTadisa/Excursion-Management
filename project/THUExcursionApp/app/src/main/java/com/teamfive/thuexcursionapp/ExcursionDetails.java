package com.teamfive.thuexcursionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ExcursionDetails extends AppCompatActivity {


    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excursion_details);

        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExcursionDetails.this, RegistrationCompleted.class);
            startActivity(intent);
        });


    }
}