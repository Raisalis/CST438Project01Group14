package com.example.project01group14;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdminCreateUserActivity extends AppCompatActivity {

    // Layout pieces
    private TextView mWelcome;
    private EditText mUsername;
    private EditText mPassword;
    private Button mCreateUser;
    private Button mBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_createuser);

        // Rig layout
        mWelcome = findViewById(R.id.textViewCreateUser);
        mUsername = findViewById(R.id.editTextCreateUsername);
        mPassword = findViewById(R.id.editTextCreatePassword);
        mCreateUser = findViewById(R.id.buttonCreateUser);
        mBack = findViewById(R.id.buttonToAdminFromCreate);

        //TODO: Create a new user given that the user does not exist.
        mCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //TODO: Go back to Admin Main Menu
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
