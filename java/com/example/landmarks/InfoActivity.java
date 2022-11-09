package com.example.landmarks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class InfoActivity extends AppCompatActivity {
    // objs
    private Button buttonB;
    private TextView nameTV;
    private TextView countryTV;
    private ImageView iconIV;
    private Switch mySwitch;


    private String name;
    private String country;
    private String region;
    private String url;
    private String extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        nameTV = findViewById(R.id.infoName);
        countryTV = findViewById(R.id.infoCountry);
        buttonB = findViewById(R.id.button);
        iconIV = findViewById(R.id.infoIcon);

        name = getIntent().getStringExtra("name");
        country = getIntent().getStringExtra("country");
        region = getIntent().getStringExtra("region");
        url = getIntent().getStringExtra("url");
        extra = getIntent().getStringExtra("extra");

        nameTV.setText(name);
        countryTV.setText(country);

        // switch case to determine which image is displayed
        switch (name) {
            case "The Pyramids of Giza":
                iconIV.setImageResource(R.drawable.pyramid);
                break;
            case "Newgrange":
                iconIV.setImageResource(R.drawable.newgrange);
                break;
            case "Christ The Redeemer":
                iconIV.setImageResource(R.drawable.christ);
                break;
            case "The Great Wall of China":
                iconIV.setImageResource(R.drawable.china);
                break;
            case "Eiffel Tower":
                iconIV.setImageResource(R.drawable.eiffel);
                break;
            case "Angkor Wat":
                iconIV.setImageResource(R.drawable.wat);
                break;
            case "Chichen-Itza":
                iconIV.setImageResource(R.drawable.chichen);
                break;
            case "Red Square":
                iconIV.setImageResource(R.drawable.moscow);
                break;
            case "Statue of Liberty":
                iconIV.setImageResource(R.drawable.liberty);
                break;
            case "The Leaning Tower of Pisa":
                iconIV.setImageResource(R.drawable.piza);
                break;
            case "Nazca Lines":
                iconIV.setImageResource(R.drawable.nazca);
                break;
            case "Great Barrier Reef":
                iconIV.setImageResource(R.drawable.reef);
                break;
            case "Taj Mahal":
                iconIV.setImageResource(R.drawable.taj);
                break;
        }

        // display toast of landmark name when click image
        iconIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG)
                            .show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(InfoActivity.this, InfoMoreActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("country", country);
                    intent.putExtra("region", region);
                    intent.putExtra("url", url);
                    intent.putExtra("extra", extra);
                    InfoActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        mySwitch = findViewById(R.id.switch2);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean switchState) {
                if (switchState) {
                    nameTV.setTextColor(getResources().getColor(R.color.white));
                    countryTV.setTextColor(getResources().getColor(R.color.white));
                } else {
                    nameTV.setTextColor(getResources().getColor(R.color.font_color));
                    countryTV.setTextColor(getResources().getColor(R.color.font_color));
                }
            }
        });
    }

}
