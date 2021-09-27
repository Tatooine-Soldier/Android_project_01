package com.example.neighbourhoodtalk;
//this file is for functionality whereas xml is for layout. App starts at line 11
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        Button b = (Button) v;
        b.setText("Pressed");
        b.setEnabled(false);
        b.setVisibility(View.GONE);

        TextView t = findViewById(R.id.editTextTextPersonName);
        t.setVisibility(View.GONE);
        Button subButton = findViewById(R.id.button3);
        subButton.setVisibility(View.GONE);

        beginGame();

        Log.d("success", "Button disabled");

//        if (counter % 2 == 0) {
//            b.setBackgroundColor(Color.rgb(100, 80, 220));
//        } else {
//            b.setBackgroundColor(Color.rgb(220, 50, 230));
//        } setCounter(this.counter+1);

        View myview = findViewById(R.id.textView);
        TextView text = (TextView) myview;
        text.setText("Playing...");


    }

    public void beginGame() {
        View gameButton = findViewById(R.id.button4);
        gameButton.setVisibility(View.VISIBLE);   //when this button is pressed the button splits
        gameButton.setBackgroundColor(Color.rgb(220, 70, 40));
    }

    public void firstSplit(View v) {
        View gameButton = findViewById(R.id.button4);
        gameButton.setVisibility(View.GONE);
        View leftButton = findViewById(R.id.button12);
        leftButton.setVisibility(View.VISIBLE);
        View rightButton = findViewById(R.id.button14);
        rightButton.setVisibility(View.VISIBLE);
    }

    public void reset(View v){
        findViewById(R.id.button).setEnabled(true);
        findViewById(R.id.button).setVisibility(View.VISIBLE);
        ((Button)findViewById(R.id.button)).setText("Begin");


        View gameButton = findViewById(R.id.button4);
        gameButton.setVisibility(View.GONE);

        View leftButton = findViewById(R.id.button12);
        leftButton.setVisibility(View.GONE);
        View rightButton = findViewById(R.id.button14);
        rightButton.setVisibility(View.GONE);

        View mytextview = findViewById(R.id.textView);
        TextView text = (TextView) mytextview;
        text.setText("My first app");

        setCounter(0);
    }

    public void handleText(View v) {
        TextView t = findViewById(R.id.editTextTextPersonName);
        String input = t.getText().toString();

        Log.d("info", input);
    }
}