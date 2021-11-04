package com.example.metar_taf;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pojo_station.Station;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "SearchActivity";

    EditText text_search;
    ImageButton btn_add;
    ListView list_search;
    ArrayList<String> searchList;
    ArrayList<Station> sendList;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        text_search = (EditText) findViewById(R.id.text_search);
        btn_add = (ImageButton) findViewById(R.id.btn_add);
        list_search = (ListView) findViewById(R.id.list_search);

        searchList = new ArrayList<String>();
        sendList = new ArrayList<Station>();

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, searchList);
        list_search.setAdapter(adapter);

        list_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb=new AlertDialog.Builder(SearchActivity.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete this airport ?");
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        searchList.remove(positionToRemove);
                        adapter.notifyDataSetChanged();
                    }});
                adb.show();
            }
        });

        btn_add.setOnClickListener( view -> {
           if (text_search.getText().toString().equals("")){
               Toast.makeText(
                       getApplicationContext(),
                       "Veuillez inscrire le code OACI d'un aéroport pour l'ajouter",
                       Toast.LENGTH_LONG).show();
           } else if (text_search.getText().toString().length()>4){
               Toast.makeText(
                       getApplicationContext(),
                       "Veuillez inscrire un code OACI valide",
                       Toast.LENGTH_LONG).show();
           } else {
               String to_add = String.valueOf(text_search.getText());
               text_search.getText().clear();
               new API_service().searchSTATION(to_add, new Callback() {
                   @Override
                   public void onFailure(@NotNull Call call, @NotNull IOException e) {
                       Toast.makeText(
                               getApplicationContext(),
                               "Aéroport non existant",
                               Toast.LENGTH_LONG).show();
                   }
                   @Override
                   public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                       final Gson gson = new Gson();
                       Log.d(TAG, "response from service = " + response);
                       if (response.code()!=200){
                           Looper.prepare();
                           Toast.makeText(
                                   getApplicationContext(),
                                   "Aéroport non existant",
                                   Toast.LENGTH_LONG).show();
                           Looper.loop();
                       }else{
                           ResponseBody body = response.body();
                           String value = body.string();
                           Station station = gson.fromJson(value, Station.class);
                           sendList.add(station);
                           Log.d(TAG, "response  en json =" + station.toString());
                           searchList.add(to_add);
                           Log.d(TAG, searchList.toString());
                       }
                   }
               });
               adapter.notifyDataSetChanged();
           }
        });

        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener( view -> {
            Intent intent = new Intent(SearchActivity.this, ResultsActivity.class);
            intent.putExtra("AIRPORT_LIST", sendList);
            ContextCompat.startActivity(view.getContext(), intent, Bundle.EMPTY);
        });
    }
}

