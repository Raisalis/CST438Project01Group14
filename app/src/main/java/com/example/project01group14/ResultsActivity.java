package com.example.project01group14;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    // layout pieces
    private TextView mWelcome;
    private TextView mIntro;
    private TextView mResults;
    private Button mTryAgain;
    private Button mMainMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // rig layout
        mWelcome = findViewById(R.id.textViewResultsWelcome);
        mIntro = findViewById(R.id.textViewCompatabilityIntro);
        mResults = findViewById(R.id.textViewResults);
        mTryAgain = findViewById(R.id.buttonTryAgain);
        mMainMenu = findViewById(R.id.buttonToMainFromResults);

        //TODO: Change mResults text to api results.

        //TODO: Try Again button returns user to calculate activity.
        mTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //TODO: Returns user to main menu.
        mMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
