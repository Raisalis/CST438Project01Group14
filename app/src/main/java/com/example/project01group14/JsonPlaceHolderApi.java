package com.example.project01group14;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("quotes")
    Call<List<Quotes>> getQuotes();
}
