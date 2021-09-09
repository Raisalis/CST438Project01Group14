package com.example.project01group14;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class AdminDeleteUserActivity extends AppCompatActivity {

    // Layout pieces
    private TextView mWelcome;
    private RecyclerView mUsers;
    private Button mBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_deleteuser);

        // Rig Layout
        mWelcome = findViewById(R.id.textViewDeleteUser);
        mUsers = findViewById(R.id.recyclerViewDeleteUserList);
        mBack = findViewById(R.id.buttonToAdminFromDelete);

        // TODO: Set up recycler view to get users from database.

        // TODO: Go back to Admin Main Menu.
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
