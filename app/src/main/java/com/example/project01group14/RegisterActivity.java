package com.example.project01group14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    // Layout pieces
    private TextView mWelcome;
    private EditText mUsername;
    private EditText mPassword;
    private Button mCreateUser;
    private Button mBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Rig layout
        mWelcome = findViewById(R.id.textViewRegisterWelcome);
        mUsername = findViewById(R.id.editTextRegisterUsername);
        mPassword = findViewById(R.id.editTextRegisterPassword);
        mCreateUser = findViewById(R.id.buttonRegisterUser);
        mBack = findViewById(R.id.buttonToLoginFromRegister);

        //TODO: Create a new user given that the user does not exist.
        mCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Go back to Login Page
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentFactory factory = new IntentFactory();
                Intent intent = factory.getIntent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
