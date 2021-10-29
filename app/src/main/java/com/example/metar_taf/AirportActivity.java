package com.example.metar_taf;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.pojo_station.Station;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class AirportActivity extends AppCompatActivity {

    ArrayList<Station> researchedAirports;
    //Station station;
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport);

        Intent intent = getIntent();
        researchedAirports = new ArrayList<>();
        if (intent != null) {
            if (intent.hasExtra("AIRPORT_LIST")) {
                researchedAirports = (ArrayList<Station>) intent.getSerializableExtra("AIRPORT_LIST");
            }
            /*if (intent.hasExtra("OACI")) {
                station = (Station) intent.getSerializableExtra("OACI");
            }*/
            if (intent.hasExtra("POSITION")) {
                pos = intent.getIntExtra("POSITION",1 );
            }
        }

        this.configureViewPager();
    }

    private void configureViewPager(){
        // 1 - Get ViewPager from layout
        ViewPager pager = (ViewPager)findViewById(R.id.activity_main_viewpager);
        // 2 - Set Adapter PageAdapter and glue it together
        pager.setAdapter(new PageAdapter(getSupportFragmentManager(), researchedAirports) {
        });
        pager.setCurrentItem(pos);
        pager.setOnPageChangeListener(new CircularViewPageHandler(pager));
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager, true);
    }

}