package com.example.landmarks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class InfoMoreActivity extends AppCompatActivity {
    //objs
    private TextView nameTV;
    private TextView countryTV;
    private TextView regionTV;
    private TextView urlTV;
    private TextView extraTV;
    private TextView didYouKnowTv;
    private ImageView iconIV;
    private TextView nameLabel;
    private TextView countryLabel;
    private TextView regionLabel;
    private TextView urlLabel;
    private Switch mySwitch;
    private RecyclerView moreInfo;

    private String name;
    private String country;
    private String region;
    private String url;
    private String extra;


    // data
    private LandmarksFromXML landmarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_more);

        // wire
        nameTV = findViewById(R.id.moreInfoName);
        nameLabel = findViewById(R.id.textView9);
        countryTV = findViewById(R.id.moreInfoCountry);
        countryLabel = findViewById(R.id.textView4);
        regionTV = findViewById(R.id.moreInfoRegion);
        regionLabel = findViewById(R.id.textView7);
        urlTV = findViewById(R.id.moreInfoURL);
        urlLabel = findViewById(R.id.textView);
        extraTV = findViewById(R.id.moreInfoExtra);
        iconIV = findViewById(R.id.moreInfoIcon);
        didYouKnowTv = findViewById(R.id.didYouKnowTV);


        // get adapter data
        name = getIntent().getStringExtra("name");
        country = getIntent().getStringExtra("country");
        region = getIntent().getStringExtra("region");
        url = getIntent().getStringExtra("url");
        extra = getIntent().getStringExtra("extra");


        // insert the data into TextView text
        nameTV.setText(name);
        countryTV.setText(country);
        regionTV.setText(region);
        String googleMapText = "Google Map: "+name;
        urlTV.setText(googleMapText);
        extraTV.setText(extra);

        // switch case to determine which image is displayed
        switch (name) {
            case "The Pyramids of Giza":
                iconIV.setImageResource(R.drawable.pyramid);
                break;
            case "Newgrange":
                iconIV.setImageResource(R.drawable.newgrange  );
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

        urlTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(InfoMoreActivity.this, WebViewActivity.class);
                    intent.putExtra("url", url);
                    intent.putExtra("name", name);
                    InfoMoreActivity.this.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };

        });

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

        mySwitch = findViewById(R.id.switch2);
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean switchState) {
                if (switchState) {
                    nameTV.setTextColor(getResources().getColor(R.color.white));
                    countryTV.setTextColor(getResources().getColor(R.color.white));
                    extraTV.setTextColor(getResources().getColor(R.color.white));
                    regionTV.setTextColor(getResources().getColor(R.color.white));
                    didYouKnowTv.setTextColor(getResources().getColor(R.color.white));
                    nameLabel.setTextColor(getResources().getColor(R.color.white));
                    countryLabel.setTextColor(getResources().getColor(R.color.white));
                    urlLabel.setTextColor(getResources().getColor(R.color.white));
                    regionLabel.setTextColor(getResources().getColor(R.color.white));
                } else {
                    nameTV.setTextColor(getResources().getColor(R.color.font_color));
                    countryTV.setTextColor(getResources().getColor(R.color.font_color));
                    extraTV.setTextColor(getResources().getColor(R.color.font_color));
                    regionTV.setTextColor(getResources().getColor(R.color.font_color));
                    didYouKnowTv.setTextColor(getResources().getColor(R.color.font_color));
                    nameLabel.setTextColor(getResources().getColor(R.color.font_color));
                    countryLabel.setTextColor(getResources().getColor(R.color.font_color));
                    urlLabel.setTextColor(getResources().getColor(R.color.font_color));
                    regionLabel.setTextColor(getResources().getColor(R.color.font_color));
                }
            }
        });
}}
