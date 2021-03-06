package com.example.metar_taf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.pojo_station.Station;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private static final String TAG = "MapsFragment";

    private static final String KEY_POSITION = "position";
    private static final String KEY_OACI = "oaci";;

    Switch switch_map;
    int position;
    Station station;

    GoogleMap map;

    boolean ready = false;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            if (station != null){
                LatLng airport= new LatLng(station.getLatitude(), station.getLongitude());
                if (googleMap != null){
                    map = googleMap;
                    map.addMarker(new MarkerOptions().position(airport).title(station.getName()));
                    //googleMap.moveCamera(CameraUpdateFactory.newLatLng(airport));
                    map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    CameraPosition cameraPosition = new CameraPosition.Builder()
                            .target(airport)      // Sets the center of the map to Mountain View
                            .zoom(12)                   // Sets the zoom
                            .bearing(0)                // Sets the orientation of the camera to east
                            .tilt(0)                   // Sets the tilt of the camera to 30 degrees
                            .build();                   // Creates a CameraPosition from the builder
                    map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }else{
                    googleMap.addMarker(new MarkerOptions().position(airport).title(station.getName()));
                    //googleMap.moveCamera(CameraUpdateFactory.newLatLng(airport));
                    googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    CameraPosition cameraPosition = new CameraPosition.Builder()
                            .target(airport)      // Sets the center of the map to Mountain View
                            .zoom(12)                   // Sets the zoom
                            .bearing(0)                // Sets the orientation of the camera to east
                            .tilt(0)                   // Sets the tilt of the camera to 30 degrees
                            .build();                   // Creates a CameraPosition from the builder
                    googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }

            }
        }
    };

    public static MapsFragment newInstance(int position, Station oaci) {
        MapsFragment fragment = new MapsFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        args.putSerializable(KEY_OACI, oaci);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_maps, container, false);

        if (getArguments() != null) {
            position = getArguments().getInt(KEY_POSITION, -1);
            station = (Station) getArguments().getSerializable(KEY_OACI);
        }

        switch_map = result.findViewById(R.id.switch1);
        switch_map.setChecked(false);
        switch_map.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true){
                    LatLng airport= new LatLng(station.getLatitude(), station.getLongitude());
                    map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                    map.setBuildingsEnabled (true);
                    CameraPosition cameraPosition = new CameraPosition.Builder()
                            .target(airport)      // Sets the center of the map to Mountain View
                            .zoom(12)                   // Sets the zoom
                            .bearing(0)                // Sets the orientation of the camera to east
                            .tilt(45)                   // Sets the tilt of the camera to 30 degrees
                            .build();                   // Creates a CameraPosition from the builder
                    map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }else{
                    LatLng airport= new LatLng(station.getLatitude(), station.getLongitude());
                    map.addMarker(new MarkerOptions().position(airport).title(station.getName()));
                    map.setBuildingsEnabled (false);
                    map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                    CameraPosition cameraPosition = new CameraPosition.Builder()
                            .target(airport)      // Sets the center of the map to Mountain View
                            .zoom(12)                   // Sets the zoom
                            .bearing(0)                // Sets the orientation of the camera to east
                            .tilt(0)                   // Sets the tilt of the camera to 30 degrees
                            .build();                   // Creates a CameraPosition from the builder
                    map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }
            }
        });

        Log.e(getClass().getSimpleName(), "onCreateView called for fragment number " + position);

        return result;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}