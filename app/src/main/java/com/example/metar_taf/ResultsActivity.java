package com.example.metar_taf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.example.pojo_station.Station;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ResultsActivity extends AppCompatActivity  {

    private static final String TAG = "ResultsActivity";
    private MapView myOpenMapView = null;
    ArrayList<Station> researchedAirports;
    private static String PROVIDER = "ResultsActivity";
    private static String KEY = "Airport_List";

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Log.d(TAG, "ON CREATE researched airport");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);

        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("AIRPORT_LIST")) {
                researchedAirports = (ArrayList<Station>) intent.getSerializableExtra("AIRPORT_LIST");
                Log.d(TAG, "liste airport after getting input extras  = " + researchedAirports.toString());
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

        Log.d(TAG, "researched airport used for display = " + researchedAirports.toString());

        for (Station pos : researchedAirports) {
            GeoPoint startPoint = new GeoPoint(pos.getLatitude(), pos.getLongitude());
            Marker startMarker = new Marker(myOpenMapView);
            startMarker.setPosition(startPoint);
            startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
            Drawable d = ResourcesCompat.getDrawable(getResources(), R.drawable.localisation, null);
            Bitmap bitmap = ((BitmapDrawable) d).getBitmap();
            Drawable dr = new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap, (int) (16.0f * getResources().getDisplayMetrics().density), (int) (20.0f * getResources().getDisplayMetrics().density), true));
            startMarker.setIcon(dr);
            //startMarker.setIcon(getResources().getDrawable(R.drawable.localisation));
            startMarker.setTitle(pos.getIcao());
            myOpenMapView.getOverlays().add(startMarker);
            startMarker.setOnMarkerClickListener(new Marker.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker, MapView mapView) {
                    Toast.makeText(
                            getApplicationContext(),
                            startMarker.getTitle(),
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ResultsActivity.this, AirportActivity.class);
                    intent.putExtra("POSITION", researchedAirports.indexOf(pos));
                    intent.putExtra("AIRPORT_LIST", researchedAirports);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    ContextCompat.startActivity(getApplicationContext(), intent, Bundle.EMPTY);

                    return false;
                }
            });
        }
    }
}
