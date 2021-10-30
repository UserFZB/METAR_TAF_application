package com.example.metar_taf;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.pojo_station.Station;


public class BlankFragment extends Fragment {


    private static final String KEY_POSITION = "position";
    private static final String KEY_OACI = "oaci";

    public BlankFragment() {
        // Required empty public constructor
    }


    public static BlankFragment newInstance(int position, Station oaci) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putSerializable(KEY_OACI, oaci);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.fragment_blank, container, false);

        FrameLayout rootView = (FrameLayout) result.findViewById(R.id.frame);
        int position = getArguments().getInt(KEY_POSITION, -1);
        Station station = (Station) getArguments().getSerializable(KEY_OACI);

        Log.e(getClass().getSimpleName(), "onCreateView called for fragment number " + position);

        return result;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //affichage child fragment par défaut à la création
        Fragment childFragment = new StationFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_view, childFragment).commit();
    }

    public void switchToFragmentMaps() {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_view, new MapsFragment()).commit();
        Log.d("FRAG : ","change to random");
    }

    public void switchToFragmentMeteo() {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_view, new MeteoFragment()).commit();
        Log.d("FRAG : ","change to meteo");
    }

    public void switchToFragmentstation() {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_view, new StationFragment()).commit();
        Log.d("FRAG : ","change to station");
    }
}