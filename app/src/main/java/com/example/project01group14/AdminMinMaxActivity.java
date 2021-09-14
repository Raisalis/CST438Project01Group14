package com.example.project01group14;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdminMinMaxActivity extends AppCompatActivity {

    // Layout Pieces
    private TextView mWelcome;
    private TextView mMinText;
    private TextView mMaxText;
    private EditText mMin;
    private EditText mMax;
    private Button mChangeMinMax;
    private Button mBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_minmax);

        // Rig Layout Pieces
        mWelcome = findViewById(R.id.textViewMinMax);
        mMinText = findViewById(R.id.textViewMin);
        mMaxText = findViewById(R.id.textViewMax);
        mMin = findViewById(R.id.editTextMin);
        mMax = findViewById(R.id.editTextMax);
        mChangeMinMax = findViewById(R.id.buttonChangeMinMax);
        mBack = findViewById(R.id.buttonToAdminFromMinMax);

        // TODO: Pre-fill min/max editTexts with current values.

        // TODO: Change values based on input.
        mChangeMinMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // TODO: Go back to Admin Main Menu
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
