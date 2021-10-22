package com.example.metar_taf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

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
        



    }
}

