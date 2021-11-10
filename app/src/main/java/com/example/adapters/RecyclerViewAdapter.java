package com.example.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.metar_taf.R;
import com.example.pojo_taf.Forecast;
import com.example.pojo_taf.WindDirection;
import com.example.pojo_taf.WindSpeed;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<Forecast> forecasts;

    public RecyclerViewAdapter(List<Forecast> forecasts)
    {
        this.forecasts = forecasts;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView forcast_time, visibility, altimeter, winds,
                probability, type, flight_rules, other, summary;

        public MyViewHolder(final View view)
        {
            super(view);

            forcast_time = view.findViewById(R.id.taf_forecast);
            visibility = view.findViewById(R.id.forecast_visibility);
            altimeter = view.findViewById(R.id.forecast_altimeter);
            winds = view.findViewById(R.id.forecast_winds);
            probability = view.findViewById(R.id.forecast_probability);
            type = view.findViewById(R.id.forecast_type);
            flight_rules = view.findViewById(R.id.forecast_flight_rules);
            other = view.findViewById(R.id.forecast_other);
            summary = view.findViewById(R.id.forecast_summary);

        }
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        Forecast forecast = forecasts.get(position);

        holder.forcast_time.setText("From "+forecast.getStartTime().getDt()+" to "+forecast.getEndTime().getDt());
        if(forecast.getVisibility() != null)
        {
            holder.visibility.setText("Visibility: "+ forecast.getVisibility().getValue());
        }else { holder.visibility.setVisibility(View.GONE);}

        if(forecast.getAltimeter() != null)
        {
            holder.altimeter.setText("Altimeter: "+forecast.getAltimeter());
        }else { holder.altimeter.setVisibility(View.GONE);}

        if(forecast.getWindDirection() != null && forecast.getWindSpeed() != null)
        {
            holder.winds.setText("Winds: " +forecast.getWindDirection().getValue()+"°/"+forecast.getWindSpeed().getValue()+" kts");
        }else { holder.winds.setVisibility(View.GONE);}

        if(forecast.getProbability() != null)
        {
            holder.probability.setText("Probability: "+forecast.getProbability());
        }else { holder.probability.setVisibility(View.GONE);}

        if(forecast.getType() != null)
        {
            holder.type.setText("Type: "+forecast.getType());
        }else { holder.type.setVisibility(View.GONE);}

        if(forecast.getFlightRules() != null)
        {
            holder.flight_rules.setText("Flight rules: "+forecast.getFlightRules());
        }else { holder.flight_rules.setVisibility(View.GONE);}

        if(forecast.getOther() != null && forecast.getOther().size() > 0)
        {
            holder.other.setText("Other: "+forecast.getOther().toString());
        }else { holder.other.setVisibility(View.GONE);}

        if(forecast.getSummary() != null)
        {
            holder.summary.setText("Summary: "+forecast.getSummary());
        }else { holder.summary.setVisibility(View.GONE);}

    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }
}
