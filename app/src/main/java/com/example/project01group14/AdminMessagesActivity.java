package com.example.project01group14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AdminMessagesActivity extends AppCompatActivity {

    // layout pieces
    private TextView mWelcome;
    private TextView m0Title;
    private TextView m25Title;
    private TextView m50Title;
    private TextView m75Title;
    private EditText m0Msg;
    private EditText m25Msg;
    private EditText m50Msg;
    private EditText m75Msg;
    private Button mChangeMsg;
    private Button mBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_defaultmsgs);

        // rig layout pieces
        mWelcome = findViewById(R.id.textViewDefaultMsgs);
        m0Title = findViewById(R.id.textView0_25);
        m25Title = findViewById(R.id.textView25_50);
        m50Title = findViewById(R.id.textView50_75);
        m75Title = findViewById(R.id.textView75_100);
        m0Msg = findViewById(R.id.editText0_25Msg);
        m25Msg = findViewById(R.id.editText25_50Msg);
        m50Msg = findViewById(R.id.editText50_75Msg);
        m75Msg = findViewById(R.id.editText75_100Msg);
        mChangeMsg = findViewById(R.id.buttonChangeMsgs);
        mBack = findViewById(R.id.buttonToAdminFromMsg);

        //TODO: Prefill editText boxes with current messages from database.

        //TODO: Get user-input and change messages.
        mChangeMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Go back to Admin menu.
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentFactory factory = new IntentFactory();
                Intent intent = factory.getIntent(AdminMessagesActivity.this, AdminMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
