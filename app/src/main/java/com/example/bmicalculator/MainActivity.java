package com.example.bmicalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.StringDef;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.bmicalculator.R.drawable.bmi;

public class MainActivity extends AppCompatActivity {
    private EditText editHeight, editWeight;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editHeight = (EditText) findViewById(R.id.editHeight);
        editWeight = (EditText) findViewById(R.id.editWeight);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double height = Double.valueOf(editHeight.getText().toString()); // getText() return CharSequence
                Double weight = Double.valueOf(editWeight.getText().toString()); // getText() return CharSequence
                Double bmi = weight/Math.pow(height/100, 2);

                String bmiRound = String.format("%.2f",bmi);
                String bmiText = getBmiText(bmi);
                String result = "ค่า BMI ที่ได้คือ : "+ bmiRound + "\n" + "อยู่ในเกณฑ์ : " + bmiText;
//
//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("ดัชนีมวลกาย");
//                dialog.setMessage(result);
//                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() { // text, listner << default is null
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        editHeight.setText("");
//                        editWeight.setText("");
//                        editHeight.requestFocus(); //เมื่อกด OK ทำให้ไปโฟกัสที่ Height
//                    }
//                });
//                dialog.show();

                Intent intent = new Intent(MainActivity.this, BmiResultActivity.class); // context, destinations
                intent.putExtra("bmi",bmi);
                intent.putExtra("result",result);
                startActivity(intent); // fire intent
            }
        });
    }
    public String getBmiText(double bmi){
        String text = "";
        if (bmi < 18.5){
            text = "น้ำหนักน้อยกว่าปกติ";
        }
        else if(bmi < 25){
            text = "น้ำหนักปกติ";
        }
        else if(bmi < 30){
            text = "น้ำหนักมากกว่าปกติ";
        }
        else {
            text = "น้ำหนักมากกว่าปกติมาก";
        }
        return text;
    }
}
