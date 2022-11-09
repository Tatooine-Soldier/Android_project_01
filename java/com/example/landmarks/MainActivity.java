package com.example.landmarks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // objs
    private RecyclerView recyclerView = null;
    private DataAdapter dataAdapter = null;
    private LandmarksFromXML landmarks = null;

    private Switch mySwitch;
    private Boolean switchState;
    private AppCompatButton exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // wire
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mySwitch = (Switch) findViewById(R.id.switch2);

        // data
        landmarks = new LandmarksFromXML(this);

        String[] names = landmarks.getNames();
        String[] countries = landmarks.getCountries();
        String[] regions = landmarks.getRegions();
        String[] urls = landmarks.getURL();
        String[] extra = landmarks.getExtra();
        String[] images = landmarks.getImage();
        dataAdapter = new DataAdapter(this, R.layout.layout_recycle_item, names, countries, regions, urls, extra, images);
        recyclerView.setAdapter(dataAdapter);

        // switch to white font if the switch is checked true
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean switchState) {
                int i = 0;
                if (switchState) {
                    for (i = 0; i < names.length; i++) {
                        RecyclerView.ViewHolder v = recyclerView.findViewHolderForAdapterPosition(i);
                        if (v != null) {
                            TextView countryTitle = v.itemView.findViewById(R.id.textView5);
                            countryTitle.setTextColor(getResources().getColor(R.color.white));
                            TextView subTitle = v.itemView.findViewById(R.id.subTitle);
                            subTitle.setTextColor(getResources().getColor(R.color.white));
                        } else {
                            System.out.println("NULL");
                        }
                    }
                } else {
                    for (i = 0; i < names.length; i++) {
                        RecyclerView.ViewHolder v = recyclerView.findViewHolderForAdapterPosition(i);
                        if (v != null) {
                            TextView countryTitle = v.itemView.findViewById(R.id.textView5);
                            countryTitle.setTextColor(getResources().getColor(R.color.font_color));
                            TextView subTitle = v.itemView.findViewById(R.id.subTitle);
                            subTitle.setTextColor(getResources().getColor(R.color.font_color));
                        } else {
                            System.out.println("NULL");
                        }

                    }
                }
            }
        });

        exitButton = findViewById(R.id.button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });


    }

}