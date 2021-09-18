package com.example.project01group14;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuotesTest {

    @Test
    public void setAuthor() {
        Quotes quote1 = new Quotes();
        quote1.setAuthor("Bob");
        assertEquals("Bob", quote1.getAuthor());
        quote1.setAuthor("Martha");
        assertNotEquals("Bob", quote1.getAuthor());
    }

    @Test
    public void setText() {
        Quotes quote1 = new Quotes();
        quote1.setText("Hi");
        assertEquals("Hi", quote1.getText());
        quote1.setText("Hello");
        assertNotEquals("Hi", quote1.getText());
    }

    @Test
    public void getAuthor() {
        Quotes quote1 = new Quotes();
        quote1.setAuthor("Bob");
        assertEquals("Bob", quote1.getAuthor());
        assertNotEquals("Martha", quote1.getAuthor());
    }

    @Test
    public void getText() {
        Quotes quote1 = new Quotes();
        quote1.setText("Hi");
        assertEquals("Hi", quote1.getText());
        assertNotEquals("Hello", quote1.getText());
    }
}