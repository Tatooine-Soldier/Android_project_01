package com.example.neighbourhoodtalk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.widget.TextView;
import android.view.View;

import org.w3c.dom.Text;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

//    public static String[] items;
    public List<String> items = new ArrayList<String>();
    public String output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void setItems(String s) {
        items.add(s);
    }

    public String getItems() {
        for (String i : items) {
            output = output + "\n" + i;
            TextView displayText = findViewById(R.id.textView6);
            displayText.setText(output);
        } return "Finished";
    }

    public void addToList(View v) {
        TextView t = findViewById(R.id.editTextTextPersonName2);
        String item = t.getText().toString();
        setItems(item);
        getItems();
//        int n = items.length;
//        String[] newArr = new String[n+1];
//
//        for (i=0;i< items.length;i++) {
//            newArr[i] = items[i];
//            System.out.println(newArr[i]);
//        }

//        TextView displayList = findViewById(R.id.textView6);
//        displayList.setText((CharSequence) items);

    }

}