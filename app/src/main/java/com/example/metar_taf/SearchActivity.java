package com.example.metar_taf;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private static final String TAG = "SearchActivity";

    EditText text_search;
    ImageButton btn_add;
    ListView list_search;
    ArrayList<String> searchList;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        text_search = (EditText) findViewById(R.id.text_search);
        btn_add = (ImageButton) findViewById(R.id.btn_add);
        list_search = (ListView) findViewById(R.id.list_search);

        searchList = new ArrayList<String>();

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
               searchList.add(to_add);
               adapter.notifyDataSetChanged();
               Log.d(TAG, searchList.toString());
               text_search.getText().clear();
           }
        });
    }
}

