package com.example.neighbourhoodtalk;
//this file is for functionality whereas xml is for layout. App starts at line 11
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    protected int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter(){
        return this.counter;
    }

    public void disable(View v) {

        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
//        Button b = (Button) v;
//        b.setText("Pressed");
//        b.setEnabled(false);
//        b.setVisibility(View.GONE);
//
//        TextView t = findViewById(R.id.editTextTextPersonName);
//        t.setVisibility(View.GONE);
//        Button subButton = findViewById(R.id.button3);
//        subButton.setVisibility(View.GONE);


        Log.d("success", "Button disabled");

//        if (counter % 2 == 0) {
//            b.setBackgroundColor(Color.rgb(100, 80, 220));
//        } else {
//            b.setBackgroundColor(Color.rgb(220, 50, 230));
//        } setCounter(this.counter+1);

//        View myview = findViewById(R.id.textView);
//        TextView text = (TextView) myview;
//        text.setText("Playing...");


    }

    public void settings(View v) {
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }


    public void handleText(View v) {
        TextView t = findViewById(R.id.editTextTextPersonName);
        String input = t.getText().toString();

        TextView displayName = findViewById(R.id.textView2);
        displayName.setText(input);

        Button sub = findViewById(R.id.button3);
        sub.setVisibility(View.GONE);

        t.setVisibility(View.GONE);

        Toast.makeText(this, input, Toast.LENGTH_LONG).show();

        Log.d("info", input);
    }
}