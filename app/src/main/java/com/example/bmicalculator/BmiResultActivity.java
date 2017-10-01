package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.bmicalculator.R.drawable.bmi;

public class BmiResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        Intent intent = getIntent();
        double bmi = intent.getDoubleExtra("bmi", 0);
        String result = intent.getStringExtra("result");

    }
}
