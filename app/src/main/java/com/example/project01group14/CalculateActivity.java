package com.example.project01group14;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CalculateActivity extends AppCompatActivity {
    private TextView displayCalculation, displayResults;
    private String name1, name2;
    private TextView editTextPersonName1;
    private TextView editTextPersonName2;
    private Button button;
    private String url;
    private Button mBack;

    private static final String TAG = "CalculateActivity";

    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "StartofCalculateActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        //displayCalculation = (TextView) findViewById(R.id.displayCalculation);
        //displayResults = (TextView) findViewById(R.id.displayResults);
        button = findViewById(R.id.buttonCalculate);
        editTextPersonName1 = findViewById(R.id.editTextPersonName1);
        editTextPersonName2 = findViewById(R.id.editTextPersonName2);
        mBack = findViewById(R.id.buttonToMainFromCalculate);

        //Intent Factory for buttons
        IntentFactory factory = new IntentFactory();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1 = (String) editTextPersonName1.getText().toString();
                name2 = (String) editTextPersonName2.getText().toString();

                OkHttpClient client = new OkHttpClient();

                String url = String.format("https://love-calculator.p.rapidapi.com/getPercentage?fname=%s&sname=%s", name1, name2);

                Log.d(TAG, "request about to send, url: " + url);

                Request request = new Request.Builder()
                        .url(url)
                        .addHeader("x-rapidapi-key", "a97bae83b7mshfca3d19522be242p14b650jsn1f245f91dca3")
                        .build();
                Log.d(TAG, "request sent: " + request);

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                        Log.d(TAG, "onFailure: Failed");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.d(TAG, "checking success: ");
                        //if(!response.isSuccessful()){

                        String myResponse = response.body().string();

                        try {
                            JSONObject obj = new JSONObject(myResponse);
                            Log.d(TAG, "Json: " + obj);
                            String percent = (String) obj.get("percentage");
                            String result = (String) obj.get("result");
                            Log.d(TAG, "percent: " + percent);

                            Intent newInt = factory.getIntent(CalculateActivity.this, ResultsActivity.class);
                            newInt.putExtra("percent", percent);
                            newInt.putExtra("result", result);
//                        newInt.putExtras(welcomeBun);
                            startActivity(newInt);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            CalculateActivity.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    //displayCalculation.setText("Something Went Wrong Try Aga");
                                    Log.d(TAG, "Error");
                                }
                            });
                        }
                        Log.d(TAG, "Fail here: ");
                    }
                });
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(CalculateActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
