package com.example.tennistracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MatchsAdapter extends ArrayAdapter<Match> {
    Match[] matchs;

    public MatchsAdapter(Context context, int textViewResourceId, Match[] objects) {
        super(context, textViewResourceId, objects);
        matchs = objects;

        // Launch the Task to retrieve the Players from the DB/JSON
        // this.plyrs = ...
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_view_matchs, null);
        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText("Match n°" + String.valueOf(matchs[position].getId()) + " at " + matchs[position].getPlace());
        return v;
    }

}