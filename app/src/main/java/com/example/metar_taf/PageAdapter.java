package com.example.metar_taf;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.pojo_station.Station;

import java.util.ArrayList;

public class PageAdapter extends FragmentStatePagerAdapter {

    // 1 - Array of colors that will be passed to PageFragment
    private ArrayList<Station> stationArrayList;

    // 2 - Default Constructor
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

