package com.example.metar_taf;

import android.util.Log;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class API_service {

    private static final String TAG = "API_Service";

    public void searchMETAR(String query, Callback callback){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("https://avwx.rest/api/metar/"+query+"?options=summary&airport=true&reporting=true&format=json&onfail=cache&token=r-He1BNsyYCyVTzA0-T8xqAVVtBlsu7ib8BWPiuZ-uc").build();
        Log.d(TAG, "requete=" + request.toString());

        client.newCall(request).enqueue(callback);
    }

    // Code à copier pour faire appel à la méthode SearchMETAR depuis une activité
    /*new API_service().searchMETAR(query, new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {

                    }
                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        final Gson gson = new Gson();
                        Log.d(TAG, "response from service = " + response);

                        ResponseBody body = response.body();
                        String value = body.string();

                        Log.d(TAG, "response body to string =" + value);
                        METAR metar = gson.fromJson(value, METAR.class);

                        Log.d(TAG, "response  en json =" + metar.toString());
                    }
                });*/

    public void searchTAF(String query, Callback callback){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("https://avwx.rest/api/taf/"+query+"?options=summary&airport=true&reporting=true&format=json&onfail=cache&token=r-He1BNsyYCyVTzA0-T8xqAVVtBlsu7ib8BWPiuZ-uc").build();
        Log.d(TAG, "requete=" + request.toString());

        client.newCall(request).enqueue(callback);
    }

    // Code à copier pour faire appel à la méthode SearchTAF depuis une activité
    /*new API_service().searchTAF(query, new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {

                    }
                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        final Gson gson = new Gson();
                        Log.d(TAG, "response from service = " + response);

                        ResponseBody body = response.body();
                        String value = body.string();

                        Taf taf = gson.fromJson(value, Taf.class);

                        Log.d(TAG, "response  en json =" + taf.toString());
                    }
                });*/

    public void searchSTATION(String query, Callback callback){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("https://avwx.rest/api/station/"+query+"?format=json&token=r-He1BNsyYCyVTzA0-T8xqAVVtBlsu7ib8BWPiuZ-uc").build();
        Log.d(TAG, "requete=" + request.toString());

        client.newCall(request).enqueue(callback);
    }

    // Code à copier pour faire appel à la méthode SearchSTATION depuis une activité
    /*new API_service().searchSTATION(query, new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {

                    }
                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        final Gson gson = new Gson();
                        Log.d(TAG, "response from service = " + response);

                        ResponseBody body = response.body();
                        String value = body.string();

                        Station station = gson.fromJson(value, Station.class);

                        Log.d(TAG, "response  en json =" + station.toString());
                    }
                });*/

}
