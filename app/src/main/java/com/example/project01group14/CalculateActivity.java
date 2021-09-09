package com.example.project01group14;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CalculateActivity extends AppCompatActivity {
    private TextView displayCalculation;
    private String name1, name2;
    private TextView editTextPersonName1;
    private TextView editTextPersonName2;
    private Button button;
    private String url;
    private static final String TAG = "CalculateActivity";

    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "StartofCalculateActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        displayCalculation = (TextView) findViewById(R.id.displayCalculation);
        button = findViewById(R.id.calculateButton);
        editTextPersonName1 = findViewById(R.id.editTextPersonName1);
        editTextPersonName2 = findViewById(R.id.editTextPersonName2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1 = (String) editTextPersonName1.getText();
                name2 = (String) editTextPersonName2.getText();
                OkHttpClient client = new OkHttpClient();
                url = "https://love-calculator.p.rapidapi.com/getPercentage?fname={name1}&sname={name2}".format(name1, name2);
                Request request = new Request.Builder()
                        .url(url)
                        .get()
                        .addHeader("x-rapidapi-host", "")
                        .addHeader("x-rapidapi-key", "")
                        .build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                        if (response.isSuccessful()) {
                            final String myResponse = response.body().string();

                            CalculateActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    displayCalculation.setText(myResponse);
                                }
                            });

                        }
                    }
                });
            }
        });
    }
}

