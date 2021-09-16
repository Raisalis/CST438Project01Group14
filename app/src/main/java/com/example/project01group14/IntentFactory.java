package com.example.project01group14;

import android.content.Context;
import android.content.Intent;

public class IntentFactory {

    //Use getIntent to get an object of type Intent
    public static Intent getIntent(Context context, Class destination) {
        return new Intent(context, destination);
    }

}
