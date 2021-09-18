package com.example.project01group14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Entity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    // Layout pieces
    private TextView mWelcome;
    private EditText mFirstname;
    private EditText mLastname;
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
        mFirstname = findViewById(R.id.editTextRegisterFirstName);
        mLastname = findViewById(R.id.editTextRegisterLastName);
        mUsername = findViewById(R.id.editTextRegisterUsername);
        mPassword = findViewById(R.id.editTextRegisterPassword);
        mCreateUser = findViewById(R.id.buttonRegisterUser);
        mBack = findViewById(R.id.buttonToLoginFromRegister);

        //Create a new user given that the user does not exist.
        mCreateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsersEntity usersEntity = new UsersEntity();
                usersEntity.setUser_first_name(mFirstname.getText().toString());
                usersEntity.setUser_last_name(mLastname.getText().toString());
                usersEntity.setUser_name(mUsername.getText().toString());
                usersEntity.setUser_password(mPassword.getText().toString());


                if (validateInput(usersEntity)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UsersDatabase usersDatabase = UsersDatabase.getInstance(getApplicationContext());
                            UsersDao userDao = usersDatabase.usersDao();
                            userDao.insert(usersEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User Registered", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
                }else{
                    Toast myToast = Toast.makeText(getApplicationContext(), "If Empty fill all fields else choose different username", Toast.LENGTH_SHORT);
                    myToast.show();
                }

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

    private Boolean validateInput(UsersEntity usersEntity){
        if(usersEntity.getUser_first_name().isEmpty() || usersEntity.getUser_last_name().isEmpty() || usersEntity.getUser_name().isEmpty() || usersEntity.getUser_password().isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
