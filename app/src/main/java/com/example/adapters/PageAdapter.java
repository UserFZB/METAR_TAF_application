package com.example.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.metar_taf.BlankFragment;
import com.example.pojo_station.Station;

import java.util.ArrayList;

public class PageAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "PageAdapter";

    private ArrayList<Station> stationArrayList;

    // Default Constructor
    public PageAdapter(FragmentManager mgr, ArrayList<Station> stations) {
        super(mgr);
        this.stationArrayList = stations;
    }

    @Override
    public int getCount() {
        return(this.stationArrayList.size());
    }

    @Override
    public Fragment getItem(int position) {
        return(BlankFragment.newInstance(position, this.stationArrayList.get(position)));
    }
}

