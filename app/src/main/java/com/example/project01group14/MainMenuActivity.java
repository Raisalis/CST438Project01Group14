package com.example.project01group14;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainMenuActivity extends AppCompatActivity {
    // Layout pieces
    private TextView textViewMainMenuWelcome, inspirationalQuote;
    private Button buttonToCalculatePage;
    // TODO: Admin page should only be visible if the user is flagged as an admin.
    private Button buttonToAdminPage;
    private Button buttonLogout;
    private static final String TAG = "QuoteRequest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);


        // Attach layout
        textViewMainMenuWelcome = findViewById(R.id.textViewMainMenuWelcome);
        buttonToCalculatePage = findViewById(R.id.buttonToCalculatePage);
        buttonToAdminPage = findViewById(R.id.buttonToAdminPage);
        buttonLogout = findViewById(R.id.buttonLogout);
        inspirationalQuote = findViewById(R.id.inspirationalQuote);

        Log.d(TAG, "Request Sending");
        OkHttpClient client = new OkHttpClient();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://type.fit/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Quotes>> call = jsonPlaceHolderApi.getQuotes();

        call.enqueue(new Callback<List<Quotes>>() {
            @Override
            public void onResponse(Call<List<Quotes>> call, Response<List<Quotes>> response) {
                if (!response.isSuccessful()) {
                    System.out.println("on response failure");
                    Log.d(TAG, "Failed here ");
                    inspirationalQuote.setText("Code: " + response.code());
                    return;
                }
                List<Quotes> quotes = response.body();
                //Log.d(TAG, "Reponse: " + quotes);


                int rnd = new Random().nextInt(quotes.size());
                Quotes use = quotes.get(rnd);
                Log.d(TAG, "Quote: " +  use.getText());
                Log.d(TAG, "Author: " +  use.getAuthor());

                inspirationalQuote.setText(use.getText() + " - " + use.getAuthor() );


            }

            @Override
            public void onFailure(Call<List<Quotes>> call, Throwable t) {
                Log.d(TAG, "Failed: ");
            }
        });

        // Intent Factory for Buttons
        IntentFactory factory = new IntentFactory();

        //Send user to Calculate page
        buttonToCalculatePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(MainMenuActivity.this, CalculateActivity.class);
                startActivity(intent);
            }
        });

        //Send user to admin page.
        buttonToAdminPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(MainMenuActivity.this, AdminMenuActivity.class);
                startActivity(intent);
            }
        });

        //When logout button is pressed, return to login page.
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(MainMenuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
