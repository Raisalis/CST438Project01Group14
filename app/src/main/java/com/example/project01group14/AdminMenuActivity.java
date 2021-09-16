package com.example.project01group14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdminMenuActivity extends AppCompatActivity {

    // Layout Parts
    private TextView mWelcome;
    private Button mCreateUser;
    private Button mDeleteUser;
    private Button mMinMax;
    private Button mDefaultMsg;
    private Button mBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmenu);

        // Rig Layout
        mWelcome = findViewById(R.id.textViewAdminMenu);
        mCreateUser = findViewById(R.id.buttonCreateUser);
        mDeleteUser = findViewById(R.id.buttonDeleteUser);
        mMinMax = findViewById(R.id.buttonChangeMinMax);
        mDefaultMsg = findViewById(R.id.buttonChangeDefaultMsgs);
        mBack = findViewById(R.id.buttonToMainFromAdmin);

        //Intent Factory for buttons
        IntentFactory factory = new IntentFactory();

        // Move to Create User (Admin)
        mCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(AdminMenuActivity.this, AdminCreateUserActivity.class);
                startActivity(intent);
            }
        });

        // Move to Delete User (Admin)
        mDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(AdminMenuActivity.this, AdminDeleteUserActivity.class);
                startActivity(intent);
            }
        });

        // Move to Min/Max (Admin)
        mMinMax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(AdminMenuActivity.this, AdminMinMaxActivity.class);
                startActivity(intent);
            }
        });

        // Move to Default Messages (Admin)
        mDefaultMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(AdminMenuActivity.this, AdminMessagesActivity.class);
                startActivity(intent);
            }
        });

        // Move back to Main Menu
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(AdminMenuActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });

    }
}
