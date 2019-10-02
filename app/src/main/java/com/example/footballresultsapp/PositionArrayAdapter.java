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

public class PositionArrayAdapter extends ArrayAdapter<Position> {

    static final int VIEW_TYPE_COUNT = 1;
    static final int VIEW_TYPE = 2;

    public PositionArrayAdapter(Context context, ArrayList<Position> items) {
        super(context, 0, items);
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }


    @Override
    public int getItemViewType(int itemPosition) {
        Position position = getItem(itemPosition);
        return VIEW_TYPE;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    @Override
    public View getView(int itemPosition, @Nullable View convertView, @NonNull ViewGroup parent) {
        Position position = getItem(itemPosition);

        if (convertView == null) {
            int layoutId = R.layout.league_list_item;
            convertView = LayoutInflater.from(getContext()).inflate(layoutId, parent, false);
        }
        TextView textViewName = convertView.findViewById(R.id.league_textView);
        ImageView leagueImage = convertView.findViewById(R.id.league_ImageView);
        return convertView;
    }
}
