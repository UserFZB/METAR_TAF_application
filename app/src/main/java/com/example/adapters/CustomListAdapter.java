package com.example.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.metar_taf.R;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter implements ListAdapter {

    private static final String TAG = "CustomListAdapter";

    private ArrayList<String> list = new ArrayList<String>();
    private Context context;

    public CustomListAdapter(ArrayList<String> list, Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_items, null);
        }

        TextView code = (TextView)view.findViewById(R.id.airport_code);
        code.setText(list.get(position));

        return view;
    }
}
