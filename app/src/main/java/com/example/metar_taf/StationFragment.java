package com.example.metar_taf;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.pojo_station.Runway;
import com.example.pojo_station.Station;

import java.util.ArrayList;
import java.util.List;

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

        TextView title = result.findViewById(R.id.airport_title);
        TextView name = result.findViewById(R.id.airport_name);
        TextView iata = result.findViewById(R.id.airport_iata);
        TextView icao = result.findViewById(R.id.airport_icao);
        TextView city = result.findViewById(R.id.airport_city);
        TextView country = result.findViewById(R.id.airport_country);
        TextView type = result.findViewById(R.id.airport_type);
        TextView elev_ft = result.findViewById(R.id.airport_elevation_ft);
        TextView elev_m = result.findViewById(R.id.airport_elevation_m);
        TextView lat = result.findViewById(R.id.airport_latitude);
        TextView lon = result.findViewById(R.id.airport_longitude);
        TextView website = result.findViewById(R.id.airport_website);
        //website.setMovementMethod(LinkMovementMethod.getInstance());
        TextView wiki = result.findViewById(R.id.airport_wiki);
        //wiki.setMovementMethod(LinkMovementMethod.getInstance());

        title.setText(station.getIcao());
        name.setText(station.getName());
        iata.setText(station.getIata());
        icao.setText(station.getIcao());
        city.setText(station.getCity());
        country.setText(station.getCountry());
        type.setText(station.getType());
        elev_ft.setText(station.getElevationFt().toString()+" ft");
        elev_m.setText(station.getElevationM().toString()+" m");
        lat.setText(station.getLatitude().toString());
        lon.setText(station.getLongitude().toString());

        TableLayout table = (TableLayout) result.findViewById(R.id.table_runway);
        List<Runway> runways = station.getRunways();
        int size = runways.size();
        TableRow[] runway_rows = new TableRow[size];
        for(int i = 0; i<size; i++)
        {
            Runway runway = runways.get(i);
            TableRow row = runway_rows[i] = new TableRow(result.getContext());
            TextView[] runway_data = new TextView[5];
            row.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            for(int j = 0; j<5; j++)
            {
                TextView data = runway_data[j] = new TextView(result.getContext());
                data.setPadding(3,3,3,3);
                data.setGravity(Gravity.CENTER);
                data.setTextColor(Color.BLACK);
                data.setTextSize(12);
                if(i%2 != 0)
                {
                    row.setBackgroundColor(0xFFE2EDF2);
                }
            }

            TextView id = runway_data[0];
            TextView length = runway_data[1];
            TextView width = runway_data[2];
            TextView surface = runway_data[3];
            TextView bearing = runway_data[4];

            id.setText(runway.getIdent1()+"/"+runway.getIdent2());
            length.setText(Math.round(runway.getLengthFt()/3.281)+" m");
            width.setText(Math.round(runway.getWidthFt()/3.281)+" m");
            surface.setText(runway.getSurface());
            bearing.setText(runway.getBearing1()+"/"+runway.getBearing2());

            row.addView(id);
            row.addView(length);
            row.addView(width);
            row.addView(surface);
            row.addView(bearing);

            table.addView(row);
        }

        if (station.getWebsite()==null){
            website.setText(getContext().getString(R.string.no_website));
        }else{
            website.setText(station.getWebsite());
        }
        if (station.getWiki()==null){
            wiki.setText(getContext().getString(R.string.no_wiki));
        }else{
            wiki.setText(station.getWiki());
        }

        Log.e(TAG, "onCreateView called for fragment number " + position);

        return result;
    }
}