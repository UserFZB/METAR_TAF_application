package com.example.metar_taf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

public class ResultsActivity extends AppCompatActivity {

    private static final String TAG = "ResultsActivity";
    private MapView myOpenMapView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        myOpenMapView = (MapView) findViewById(R.id.mapview);
        myOpenMapView.setBuiltInZoomControls(true);
        myOpenMapView.setClickable(true);
        myOpenMapView.setTileSource(TileSourceFactory.MAPNIK);
        MapController mMapController = (MapController) myOpenMapView.getController();
        mMapController.setZoom(3);
        GeoPoint gPt = new GeoPoint(0, -30);
        mMapController.setCenter(gPt);

        MyLocationNewOverlay mLocationOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getApplicationContext()), myOpenMapView);
        mLocationOverlay.enableMyLocation();
        myOpenMapView.setMultiTouchControls(true);
        myOpenMapView.getOverlays().add(mLocationOverlay);

        GeoPoint startPoint = new GeoPoint(0, -30);
        Marker startMarker = new Marker(myOpenMapView);
        startMarker.setPosition(startPoint);
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        startMarker.setIcon(getResources().getDrawable(R.drawable.ic_localisation_background));
        startMarker.setTitle("Start point");
        myOpenMapView.getOverlays().add(startMarker);

    }
}