package com.example.footballresultsapp;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LeagueArrayAdapter extends ArrayAdapter<League> {

    static final int VIEW_TYPE_COUNT = 1;
    static final int VIEW_TYPE = 2;

    public LeagueArrayAdapter(Context context, ArrayList<League> items) {
        super(context, 0, items);
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }


    @Override
    public int getItemViewType(int position) {
        League league = getItem(position);
        return VIEW_TYPE;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        League league = getItem(position);

        if (convertView == null) {
            int layoutId = R.layout.list_item;
            convertView = LayoutInflater.from(getContext()).inflate(layoutId, parent, false);
        }
        TextView textViewName = convertView.findViewById(R.id.league_textView);
        ImageView leagueImage = convertView.findViewById(R.id.league_ImageView);
        textViewName.setText(league.getName());
        switch (league.getName()) {
            case "UEFA Champions League":
                leagueImage.setImageResource(R.drawable.uefa_champions_league);
                break;
            case "Premier League":
                leagueImage.setImageResource(R.drawable.premier_league);
                break;
            case "Primera Division":
                leagueImage.setImageResource(R.drawable.primera_division);
                break;
            case "Ligue 1":
                leagueImage.setImageResource(R.drawable.ligue_1);
                break;
            case "Bundesliga":
                leagueImage.setImageResource(R.drawable.bundesliga);
                break;
            case "Serie A":
                leagueImage.setImageResource(R.drawable.serie_a);
                break;

        }
        return convertView;
    }
}