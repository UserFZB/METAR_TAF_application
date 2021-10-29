package com.example.metar_taf;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

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
        TextView name = (TextView) result.findViewById(R.id.fragment_page_title);
        TextView pos = (TextView) result.findViewById(R.id.fragment_page_pos);
        int position = getArguments().getInt(KEY_POSITION, -1);
        Station station = (Station) getArguments().getSerializable(KEY_OACI);

        pos.setText("Page numéro " + position);
        name.setText(station.getName());

        Log.e(getClass().getSimpleName(), "onCreateView called for fragment number " + position);

        return result;
    }
}