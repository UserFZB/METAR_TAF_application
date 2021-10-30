package com.example.metar_taf;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.pojo_station.Station;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class AirportActivity extends AppCompatActivity {

    ArrayList<Station> researchedAirports;
    int position;
    BlankFragment fragment;
    ViewPager pager;
    Station current;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport);

        bottomNav = findViewById(R.id.nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        Intent intent = getIntent();
        researchedAirports = new ArrayList<>();
        if (intent != null) {
            if (intent.hasExtra("AIRPORT_LIST")) {
                researchedAirports = (ArrayList<Station>) intent.getSerializableExtra("AIRPORT_LIST");
            }
            if (intent.hasExtra("POSITION")) {
                position = intent.getIntExtra("POSITION",1 );
            }
            if (intent.hasExtra("STATION")) {
                current = (Station) intent.getSerializableExtra("STATION");
            }
        }
        this.configureViewPager();
    }

    private void configureViewPager(){
        pager = (ViewPager)findViewById(R.id.activity_main_viewpager);
        pager.setAdapter(new PageAdapter(getSupportFragmentManager(), researchedAirports) {});
        pager.setCurrentItem(position);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager, true);
        pager.addOnPageChangeListener(new CircularViewPageHandler(pager,bottomNav));
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            fragment = (BlankFragment) pager.getAdapter().instantiateItem(pager, pager.getCurrentItem());
            switch (item.getItemId()) {
                case R.id.nav_map:
                    fragment.switchToFragmentMaps();
                    break;
                case R.id.nav_meteo:
                    fragment.switchToFragmentMeteo();
                    break;
                case R.id.nav_station:
                    fragment.switchToFragmentstation();
                    break;
            }
            return true;
        }
    };
}