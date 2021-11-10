package com.example.metar_taf;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.adapters.RecyclerViewAdapter;
import com.example.pojo_metar.METAR;
import com.example.pojo_station.Station;
import com.example.pojo_taf.Forecast;
import com.example.pojo_taf.Taf;

import java.util.List;

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

        TextView title = result.findViewById(R.id.airport_title);
        TextView name = result.findViewById(R.id.airport_name);

        TextView metar_txt = result.findViewById(R.id.metar_coded);
        TextView time = result.findViewById(R.id.metar_time);
        TextView temperature = result.findViewById(R.id.metar_temperature);
        TextView dewpoint = result.findViewById(R.id.metar_dewpoint);
        TextView humidity = result.findViewById(R.id.metar_humidity);
        TextView pressure = result.findViewById(R.id.metar_pressure);
        TextView wind = result.findViewById(R.id.metar_winds);
        TextView visibility = result.findViewById(R.id.metar_visibility);

        TextView taf_txt = result.findViewById(R.id.taf_coded);
        RecyclerView recyclerView_forecasts = result.findViewById(R.id.forecast_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(result.getContext());
        recyclerView_forecasts.setLayoutManager(layoutManager);

        title.setText(station.getIcao());
        name.setText(station.getName());

        if(metar!=null){
                metar_txt.setText(metar.getRaw());
                time.setText(metar.getTime().getDt().toString());
                temperature.setText(metar.getTemperature().getValue().toString());
                dewpoint.setText(metar.getDewpoint().getValue().toString());
                humidity.setText(metar.getRelativeHumidity().toString());
                pressure.setText((metar.getPressureAltitude()+" ("+metar.getAltimeter().getValue())+" mb)");
                wind.setText(metar.getWindDirection().getValue()+"°/"+metar.getWindSpeed().getValue()+" kts");
                visibility.setText(metar.getVisibility().getValue().toString());
        }
        if(taf!=null){
            taf_txt.setText(taf.getRaw());
            List<Forecast> forecasts = taf.getForecast();
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(forecasts);
            recyclerView_forecasts.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }


        Log.e(TAG, "onCreateView called for fragment number " + position);

        return result;
    }
}