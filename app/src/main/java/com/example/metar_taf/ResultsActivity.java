package com.example.metar_taf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.pojo_station.Station;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    private static final String TAG = "ResultsActivity";
    private MapView myOpenMapView = null;
    ArrayList<Station> researchedAirports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        Intent intent= getIntent();
        researchedAirports = new ArrayList<>();
        if (intent != null){
            if (intent.hasExtra("AIRPORT_LIST")) {
                researchedAirports = (ArrayList<Station>) intent.getSerializableExtra("AIRPORT_LIST");
            }
        }
        
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

        for (Station pos : researchedAirports){
            GeoPoint startPoint = new GeoPoint(pos.getLatitude(), pos.getLongitude());
            Marker startMarker = new Marker(myOpenMapView);
            startMarker.setPosition(startPoint);
            startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
            startMarker.setIcon(getResources().getDrawable(R.drawable.localisation));
            startMarker.setTitle("Start point");
            myOpenMapView.getOverlays().add(startMarker);
        }
    }
}