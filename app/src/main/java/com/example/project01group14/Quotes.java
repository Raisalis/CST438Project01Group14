package com.example.project01group14;

import com.google.gson.annotations.SerializedName;

public class Quotes {
    private String author;
    private String text;

    public void setAuthor(String a) {
        author = a;
    }

    public void setText(String t) {
        text = t;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

}
