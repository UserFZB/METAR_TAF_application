package com.example.metar_taf;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.pojo_metar.METAR;
import com.example.pojo_station.Station;
import com.example.pojo_taf.Taf;

public class MeteoFragment extends Fragment {

    private static final String TAG = "MeteoFragment";

    private static final String KEY_POSITION = "position";
    private static final String KEY_OACI = "oaci";
    private static final String KEY_METAR = "metar";
    private static final String KEY_TAF = "taf";

    int position;
    Station station;
    METAR metar = null;
    Taf taf = null;

    public MeteoFragment() {
        // Required empty public constructor
    }

    public static MeteoFragment newInstance(int position, Station oaci, METAR metar, Taf taf) {
        MeteoFragment fragment = new MeteoFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putSerializable(KEY_OACI, oaci);
        args.putSerializable(KEY_METAR, metar);
        args.putSerializable(KEY_TAF, taf);
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
        View result = inflater.inflate(R.layout.fragment_meteo, container, false);

        if (getArguments() != null) {
            position = getArguments().getInt(KEY_POSITION, -1);
            station = (Station) getArguments().getSerializable(KEY_OACI);
            metar = (METAR) getArguments().getSerializable(KEY_METAR);
            taf = (Taf) getArguments().getSerializable(KEY_TAF);
        }

        Log.d(TAG, station.toString());

        FrameLayout rootView = (FrameLayout) result.findViewById(R.id.frame);

        TextView metar_txt = result.findViewById(R.id.metar_coded);
        TextView taf_txt = result.findViewById(R.id.taf_coded);

        if(metar!=null){
            metar_txt.setText(metar.getStation());
        }
        if(taf!=null){
            taf_txt.setText(taf.getMeta().toString());
        }


        Log.e(TAG, "onCreateView called for fragment number " + position);

        return result;
    }
}