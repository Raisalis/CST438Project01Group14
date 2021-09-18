package com.example.project01group14;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
    private static final String TAG = "MainActivity";
    private Button mCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attach layout
        textViewLoginWelcome = findViewById(R.id.textViewLoginWelcome);
        editTextLoginUsername = findViewById(R.id.editTextLoginUsername);
        editTextLoginPassword = findViewById(R.id.editTextLoginPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        mCreateAccount = findViewById(R.id.buttonToRegisterFromLogin);

        // Intent Factory for buttons
        IntentFactory factory = new IntentFactory();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextLoginUsername.getText().toString();
                String password = editTextLoginPassword.getText().toString();

                if(username.isEmpty() || password.isEmpty()){
                    Toast.makeText(MainActivity.this, "All fields required", Toast.LENGTH_SHORT).show();
                }else{
                    UsersDatabase usersDatabase = UsersDatabase.getInstance(getApplicationContext());
                    UsersDao usersDao = usersDatabase.usersDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UsersEntity usersEntity = usersDao.login(username, password);
                            if (!validate(usersEntity)){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else{
                                //Toast.makeText(getApplicationContext(), "You are Logged In", Toast.LENGTH_LONG).show();
                                String name = usersEntity.getUser_name();
                                Log.d(TAG, "USERNAME HERE FAILED: " + name);
                                int userId = usersEntity.getId();
                                Intent intent = new Intent(MainActivity.this, MainMenuActivity.class);
                                intent.putExtra("name", name);
                                intent.putExtra("userId", userId);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                            }
                        }
                    }).start();
                }
            }
        });

        //Moves user to make a new account
        mCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    //Validate Username and Password
    public Boolean validate(UsersEntity usersEntity) {
        if(usersEntity == null) {
            return false;
        } else {
            return true;
        }
    }
}