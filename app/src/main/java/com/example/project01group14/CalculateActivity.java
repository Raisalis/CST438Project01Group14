package com.example.project01group14;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalculateActivity extends AppCompatActivity {
    //Layout pieces
    private TextView mTitle;
    private TextView mInstructions;
    private EditText mPersonName1;
    private EditText mPersonName2;
    private Button mCalculate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        // Rig layout pieces
        mTitle = findViewById(R.id.textViewCalculatorTitle);
        mInstructions = findViewById(R.id.textViewCalculatorInstructions);
        mPersonName1 = findViewById(R.id.editTextPersonName1);
        mPersonName2 = findViewById(R.id.editTextPersonName2);
        mCalculate = findViewById(R.id.buttonCalculate);

        //TODO: Get editText values when button is pressed.
        //TODO: Send all necessary info to results page if viable. Otherwise, send error message.
        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
