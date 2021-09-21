package com.example.neighbourhoodtalk;
//this file is for functionality whereas xml is for layout. App starts at line 11
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void disable(View v) {
        v.setEnabled(false);
        v.setBackgroundColor(Color.rgb(100, 80, 220));
        v.setPressed(true);
    }
}