package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.bmicalculator.R.drawable.bmi;

public class BmiResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        Intent intent = getIntent();
        String result = intent.getStringExtra("result");
        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(result);

    }

}
