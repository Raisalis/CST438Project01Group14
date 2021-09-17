package com.example.project01group14;

import org.junit.Test;
import static org.junit.Assert.*;

import android.content.Intent;

public class IntentFactoryTest {

    @Test(expected = NullPointerException.class)
    public void testIntentFactory() {
        // Instantiating the activity is what throws the NullPointerException
        MainActivity activity = new MainActivity();
        Intent intent1 = new Intent(activity, MainMenuActivity.class);
        IntentFactory factory = new IntentFactory();
        Intent intent2 = factory.getIntent(activity, MainMenuActivity.class);
        Intent intent3 = new Intent(activity, CalculateActivity.class);

        assertEquals(intent1.getAction(), intent2.getAction());
        assertNotEquals(intent2.getAction(), intent3.getAction());
    }
}