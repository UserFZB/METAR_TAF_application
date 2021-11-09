package com.example.metar_taf;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.pojo_metar.METAR;
import com.example.pojo_station.Station;
import com.example.pojo_taf.Taf;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class BlankFragment extends Fragment {

    private static final String TAG = "BlankFragment";

    private static final String KEY_POSITION = "position";
    private static final String KEY_OACI = "oaci";
    int position;
    Station station;
    METAR metar = null;
    Taf taf = null;
    ProgressDialog progressDialog;

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
        if (getArguments() != null) {
            position = getArguments().getInt(KEY_POSITION, -1);
            station = (Station) getArguments().getSerializable(KEY_OACI);
        }

        progressDialog = new ProgressDialog(getContext());

        new API_service().searchMETAR(station.getIcao(), new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final Gson gson = new Gson();
                Log.d(TAG, "response from service = " + response);
                if (response.code() != 200) {
                    Looper.prepare();
                    Toast.makeText(
                            getContext(),
                            getContext().getString(R.string.no_airport),
                            Toast.LENGTH_LONG).show();
                    Looper.loop();
                } else {
                    ResponseBody body = response.body();
                    String value = body.string();

                    Log.d(TAG, "response body to string =" + value);
                    metar = gson.fromJson(value, METAR.class);
                    while(metar==null){
                        progressDialog.setMessage("Please Wait");
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                    }
                    progressDialog.dismiss();
                    Log.d(TAG, "response  en json =" + metar.toString());
                }

            }
        });

        new API_service().searchTAF(station.getIcao(), new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final Gson gson = new Gson();
                Log.d(TAG, "response from service = " + response);
                if (response.code() != 200) {
                    Looper.prepare();
                    Toast.makeText(
                            getContext(),
                            getContext().getString(R.string.no_airport),
                            Toast.LENGTH_LONG).show();
                    Looper.loop();
                } else {
                    ResponseBody body = response.body();
                    String value = body.string();

                    Log.d(TAG, "response body to string =" + value);
                    taf = gson.fromJson(value, Taf.class);
                    while(taf==null){
                        progressDialog.setMessage("Please Wait");
                        progressDialog.setCancelable(false);
                        progressDialog.show();
                    }
                    progressDialog.dismiss();
                    Log.d(TAG, "response  en json =" + taf.toString());
                }
            }
        });
        return result;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //affichage child fragment par défaut à la création
        //Fragment childFragment = new StationFragment(position, station);
        Fragment childFragment = StationFragment.newInstance(position, station);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_view, childFragment).commit();
    }

    public void switchToFragmentMaps() {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_view, MapsFragment.newInstance(position, station)).commit();
        Log.d(TAG, "change to random");
    }

    public void switchToFragmentMeteo() {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_view, MeteoFragment.newInstance(position, station, metar, taf)).commit();
        Log.d(TAG, "change to meteo");
    }

    public void switchToFragmentstation() {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container_view, StationFragment.newInstance(position, station)).commit();
        Log.d(TAG, "change to station");
    }
}