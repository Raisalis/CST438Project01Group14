package com.example.project01group14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Layout pieces
    private TextView textViewLoginWelcome;
    private EditText editTextLoginUsername;
    private EditText editTextLoginPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attach layout
        textViewLoginWelcome = findViewById(R.id.textViewLoginWelcome);
        editTextLoginUsername = findViewById(R.id.editTextLoginUsername);
        editTextLoginPassword = findViewById(R.id.editTextLoginPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextLoginUsername.getText().toString();
                String password = editTextLoginPassword.getText().toString();
                if (validate(username, password)) {
                    //TODO: Change to Intent Factory.
                    Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
                    startActivity(intent);
                } else {
                    Toast myToast = Toast.makeText(MainActivity.this, "Incorrect Username or Password. Please try again.", Toast.LENGTH_LONG);
                    myToast.show();
                }
            }
        });
    }

    //Validate Username and Password
    public Boolean validate(String username, String password) {
        //TODO: Get login information from the database instead of setting defaults.
        //NOTE: Might need to change how this is validated based on how database is set-up.
        String actualUser = "test";
        String actualPass = "test";
        if(username.equals(actualUser) && password.equals(actualPass)) {
            return true;
        } else {
            return false;
        }
    }
}