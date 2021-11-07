package com.example.metar_taf;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.pojo_station.Station;

public class StationFragment extends Fragment {

    private static final String TAG = "StationFragment";

    private static final String KEY_POSITION = "position";
    private static final String KEY_OACI = "oaci";;

    int position;
    Station station;

    public StationFragment() {
        // Required empty public constructor
    }

    public static StationFragment newInstance(int position, Station oaci) {
        StationFragment fragment = new StationFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putSerializable(KEY_OACI, oaci);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_station, container, false);

        if (getArguments() != null) {
            position = getArguments().getInt(KEY_POSITION, -1);
            station = (Station) getArguments().getSerializable(KEY_OACI);
        }

        Log.d("STATION_TR",station.toString());

        FrameLayout rootView = (FrameLayout) result.findViewById(R.id.frame);

        TextView name = result.findViewById(R.id.airport_name);
        TextView wiki = result.findViewById(R.id.airport_wiki);

        name.setText(station.getName());
        wiki.setText(station.getWiki());

        Log.e(TAG, "onCreateView called for fragment number " + position);

        return result;

    }
}