package com.example.project01group14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {
    // Layout pieces
    private TextView textViewMainMenuWelcome;
    private Button buttonToCalculatePage;
    // TODO: Admin page should only be visible if the user is flagged as an admin.
    private Button buttonToAdminPage;
    private Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);


        // Attach layout
        textViewMainMenuWelcome = findViewById(R.id.textViewMainMenuWelcome);
        buttonToCalculatePage = findViewById(R.id.buttonToCalculatePage);
        buttonToAdminPage = findViewById(R.id.buttonToAdminPage);
        buttonLogout = findViewById(R.id.buttonLogout);

        // Intent Factory for Buttons
        IntentFactory factory = new IntentFactory();

        //Send user to Calculate page
        buttonToCalculatePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(MainMenuActivity.this, CalculateActivity.class);
                startActivity(intent);
            }
        });

        //Send user to admin page.
        buttonToAdminPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(MainMenuActivity.this, AdminMenuActivity.class);
                startActivity(intent);
            }
        });

        //When logout button is pressed, return to login page.
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(MainMenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
