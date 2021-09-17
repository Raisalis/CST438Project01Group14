package com.example.project01group14;

import android.content.Intent;
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
    private TextView mResults,mPercentage;
    private Button mTryAgain;
    private Button mMainMenu;
    private Bundle buns;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // rig layout
        mWelcome = findViewById(R.id.textViewResultsWelcome);
        mIntro = findViewById(R.id.textViewCompatabilityIntro);
        mPercentage = findViewById(R.id.textViewPercentage);
        mResults = findViewById(R.id.textViewResults);
        mTryAgain = findViewById(R.id.buttonTryAgain);
        mMainMenu = findViewById(R.id.buttonToMainFromResults);

        //TODO: Change mResults text to api results.
        buns = getIntent().getExtras();
        mPercentage.setText( buns.getString("percent") + "%");
        mResults.setText(buns.getString("result") + "results");


        //Intent Factory for buttons
        IntentFactory factory = new IntentFactory();


        //Try Again button returns user to calculate activity.
        mTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(ResultsActivity.this, CalculateActivity.class);
                startActivity(intent);
            }
        });

        //Returns user to main menu.
        mMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(ResultsActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}