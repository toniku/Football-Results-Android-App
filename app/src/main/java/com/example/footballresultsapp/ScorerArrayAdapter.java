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
import android.widget.TextView;

import java.util.ArrayList;

public class ScorerArrayAdapter extends ArrayAdapter<Scorer> {

    static final int VIEW_TYPE_COUNT = 1;
    static final int VIEW_TYPE = 2;

    public ScorerArrayAdapter(Context context, ArrayList<Scorer> items) {
        super(context, 0, items);
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }


    @Override
    public int getItemViewType(int itemPosition) {
        Scorer scorer = getItem(itemPosition);
        return VIEW_TYPE;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    @Override
    public View getView(int itemPosition, @Nullable View convertView, @NonNull ViewGroup parent) {
        Scorer scorer = getItem(itemPosition);

        if (convertView == null) {
            int layoutId = R.layout.scorers_list_item;
            convertView = LayoutInflater.from(getContext()).inflate(layoutId, parent, false);
        }

        TextView scorerName = convertView.findViewById(R.id.scorerName);
        TextView scorerTeamName = convertView.findViewById(R.id.scorerTeamName);
        TextView goals = convertView.findViewById(R.id.goals);

        scorerName.setText(scorer.getScorerName());
        scorerTeamName.setText(scorer.getTeamName());
        goals.setText(String.valueOf(scorer.getGoals()));

        return convertView;
    }
}
