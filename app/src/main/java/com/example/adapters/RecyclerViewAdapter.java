package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.metar_taf.R;
import com.example.pojo_taf.Forecast;
import com.example.pojo_taf.Units;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private List<Forecast> forecasts;
    Context context;
    Units units;

    public RecyclerViewAdapter(List<Forecast> forecasts, Context nContext, Units unit)
    {
        this.forecasts = forecasts;
        this.units = unit;
        this.context = nContext;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView forecast_time, visibility, altimeter, winds,
                probability, type, flight_rules, other, summary, clouds;

        public MyViewHolder(final View view)
        {
            super(view);

            forecast_time = view.findViewById(R.id.taf_forecast);
            visibility = view.findViewById(R.id.forecast_visibility);
            altimeter = view.findViewById(R.id.forecast_altimeter);
            winds = view.findViewById(R.id.forecast_winds);
            probability = view.findViewById(R.id.forecast_probability);
            type = view.findViewById(R.id.forecast_type);
            flight_rules = view.findViewById(R.id.forecast_flight_rules);
            other = view.findViewById(R.id.forecast_other);
            summary = view.findViewById(R.id.forecast_summary);
            clouds = view.findViewById(R.id.forecast_clouds);
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

        holder.forecast_time.setText(context.getString(R.string.from)+" "+forecast.getStartTime().getDt().substring(0,10)+" "+forecast.getStartTime().getDt().substring(11,19)+
                "\n"+context.getString(R.string.to)+" "+forecast.getEndTime().getDt().substring(0,10)+" "+forecast.getEndTime().getDt().substring(11,19));
        if(forecast.getVisibility() != null)
        {
            holder.visibility.setText(context.getString(R.string.visibility)+" "+forecast.getVisibility().getValue()+" "+units.getVisibility());
        }else { holder.visibility.setVisibility(View.GONE);}

        if(forecast.getAltimeter() != null)
        {
            holder.altimeter.setText(context.getString(R.string.altimeter)+" "+forecast.getAltimeter()+" "+units.getAltimeter());
        }else { holder.altimeter.setVisibility(View.GONE);}

        if(forecast.getWindDirection() != null && forecast.getWindSpeed() != null)
        {
            holder.winds.setText(context.getString(R.string.winds)+" "+forecast.getWindDirection().getValue()+" ° / "+forecast.getWindSpeed().getValue()+" "+units.getWindSpeed());
        }else { holder.winds.setVisibility(View.GONE);}

        if(forecast.getProbability() != null)
        {
            holder.probability.setText(context.getString(R.string.probability)+" "+forecast.getProbability());
        }else { holder.probability.setVisibility(View.GONE);}

        if(forecast.getType() != null)
        {
            holder.type.setText(context.getString(R.string.type)+" "+forecast.getType());
        }else { holder.type.setVisibility(View.GONE);}

        if(forecast.getFlightRules() != null)
        {
            holder.flight_rules.setText(context.getString(R.string.rules)+" "+forecast.getFlightRules());
        }else { holder.flight_rules.setVisibility(View.GONE);}

        if(forecast.getOther() != null && forecast.getOther().size() > 0)
        {
            holder.other.setText(context.getString(R.string.other)+" "+forecast.getOther().toString());
        }else { holder.other.setVisibility(View.GONE);}

        if(forecast.getSummary() != null)
        {
            holder.summary.setText(forecast.getSummary());
        }else { holder.summary.setVisibility(View.GONE);}

        if(forecast.getClouds().size()!=0)
        {
            String all_clouds = context.getString(R.string.clouds)+" ";
            int nb_clouds=forecast.getClouds().size();
            for (int i=0; i<nb_clouds;i++){
                all_clouds+= forecast.getClouds().get(i).getType() +" altitude "+ forecast.getClouds().get(i).getAltitude()+" "+units.getAltitude()+" / ";
            }
            all_clouds = all_clouds.substring(0,all_clouds.length()-3);
            holder.clouds.setText(all_clouds);
        }else { holder.clouds.setVisibility(View.GONE);}

    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }
}
