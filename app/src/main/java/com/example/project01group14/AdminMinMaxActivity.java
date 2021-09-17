package com.example.project01group14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        mWelcome = (TextView) findViewById(R.id.textViewMinMax);
        //mMinText = Integer.parseInt(mMinText.getText().toString());
        mMinText = (TextView) findViewById(R.id.textViewMin);
        mMaxText = (TextView) findViewById(R.id.textViewMax);
        mMin = (EditText) findViewById(R.id.editTextMin);
        mMax = (EditText) findViewById(R.id.editTextMax);
        mChangeMinMax = (Button) findViewById(R.id.buttonChangeValues);
        mBack = (Button) findViewById(R.id.buttonToAdminFromMinMax);

        //Pre-fill min/max editTexts with current values.

        int min = 10;
        int max = 20;
        
        //Change values based on input.
        mChangeMinMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int cMin1 = Integer.parseInt(mMin.getText().toString());
                int cMax1 = Integer.parseInt(mMax.getText().toString());

                if(cMin1 > cMax1) {
                    Toast myToast = Toast.makeText(AdminMinMaxActivity.this, "Enter valid number", Toast.LENGTH_LONG);
                    myToast.show();

                } else {
                    Toast myToast = Toast.makeText(AdminMinMaxActivity.this, "Successfully changed.", Toast.LENGTH_LONG);
                    myToast.show();
                }
            }
        });

        //Go back to Admin Main Menu
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentFactory factory = new IntentFactory();
                Intent intent = factory.getIntent(AdminMinMaxActivity.this, AdminMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
