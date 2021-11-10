package com.example.metar_taf;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapters.CustomListAdapter;
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
    ProgressDialog progressDialog;
    CustomListAdapter customAdapter;

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

        customAdapter = new CustomListAdapter(searchList, this);
        list_search.setAdapter(customAdapter);

        list_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder adb = new AlertDialog.Builder(SearchActivity.this);
                adb.setTitle(getApplicationContext().getString(R.string.delete));
                adb.setMessage(getApplicationContext().getString(R.string.confirm_delete));
                final int positionToRemove = position;
                adb.setNegativeButton(getApplicationContext().getString(R.string.cancel), null);
                adb.setPositiveButton(getApplicationContext().getString(R.string.confirm), new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        searchList.remove(positionToRemove);
                        sendList.remove(positionToRemove);
                        customAdapter.notifyDataSetChanged();
                    }
                });
                adb.show();
            }
        });

        btn_add.setOnClickListener(view -> {
            if (text_search.getText().toString().equals("")) {
                Toast.makeText(
                        getApplicationContext(),
                        getApplicationContext().getString(R.string.write),
                        Toast.LENGTH_LONG).show();
            } else if (text_search.getText().toString().length() > 4) {
                Toast.makeText(
                        getApplicationContext(),
                        getApplicationContext().getString(R.string.code_not_valid),
                        Toast.LENGTH_LONG).show();
            } else {
                String to_add = String.valueOf(text_search.getText());
                if (searchList.contains(to_add)) {
                    Toast.makeText(
                            getApplicationContext(),
                            getApplicationContext().getString(R.string.already),
                            Toast.LENGTH_LONG).show();
                } else {
                    text_search.getText().clear();
                    MyAsyncTasks myAsyncTasks = new MyAsyncTasks();
                    myAsyncTasks.execute(to_add);
                }
                text_search.getText().clear();
            }
        });

        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(view -> {
            Intent intent = new Intent(SearchActivity.this, ResultsActivity.class);
            intent.putExtra("AIRPORT_LIST", sendList);
            Log.d(TAG, "liste envoyée =" + sendList.toString());
            ContextCompat.startActivity(view.getContext(), intent, Bundle.EMPTY);
        });
    }

    class MyAsyncTasks extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(SearchActivity.this);
            progressDialog.setMessage(getApplicationContext().getString(R.string.wait));
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            final String[] result = new String[1];
            new API_service().searchSTATION(params[0], new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    onPostExecute(getApplicationContext().getString(R.string.error_request));
                    result[0] = "error";
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    final Gson gson = new Gson();
                    Log.d(TAG, "response from service = " + response);
                    if (response.code() != 200) {
                        onPostExecute(getApplicationContext().getString(R.string.no_airport));
                        result[0] = "error";
                    } else {
                        ResponseBody body = response.body();
                        String value = body.string();
                        Station station = gson.fromJson(value, Station.class);
                        while(station==null){

                        }
                        sendList.add(station);
                        Log.d(TAG, "response  en json =" + station.toString());
                        searchList.add(params[0]);
                        Log.d(TAG, searchList.toString());
                        result[0] = "reussi";
                        onPostExecute("done");
                    }
                }
            });
            return result[0];
        }

        @Override
        protected void onPostExecute(String s) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (s == getApplicationContext().getString(R.string.no_airport)) {
                        Toast.makeText(
                                getApplicationContext(),
                                getApplicationContext().getString(R.string.no_airport),
                                Toast.LENGTH_LONG).show();
                    } else if (s == getApplicationContext().getString(R.string.error_request)) {
                        Toast.makeText(
                                getApplicationContext(),
                                getApplicationContext().getString(R.string.error_request),
                                Toast.LENGTH_LONG).show();
                    } else {
                        customAdapter.notifyDataSetChanged();
                    }
                }
            });
            progressDialog.dismiss();
        }
    }
}

