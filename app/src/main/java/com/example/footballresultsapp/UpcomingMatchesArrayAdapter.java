package com.example.footballresultsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Objects;

public class UpcomingMatchesArrayAdapter extends ArrayAdapter<Match> {

    private static final int VIEW_TYPE_COUNT = 1;
    private static final int VIEW_TYPE = 2;

    public UpcomingMatchesArrayAdapter(Context context, ArrayList<Match> upcoming) {
        super(context, 0, upcoming);
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }


    @Override
    public int getItemViewType(int itemPosition) {
        return VIEW_TYPE;
    }

    @SuppressLint("ViewHolder")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    @Override
    public View getView(int itemPosition, @Nullable View convertView, @NonNull ViewGroup parent) {
        Match match = getItem(itemPosition);

        int earlier = 0;
        if (itemPosition > 0) {
            earlier = itemPosition - 1;
        }
        Match earlierMatch = getItem(earlier);

        int layoutId;
        assert match != null;
        String unParsedDate = match.getDate();
        String parsedDate = unParsedDate.substring(0, 10);
        String parsedTime = unParsedDate.substring(11, 16);
        String earlierMatchDate = Objects.requireNonNull(earlierMatch).getDate().substring(0, 10);

        if (earlierMatchDate.equals(parsedDate)) {
            layoutId = R.layout.upcoming_match_list_item;
        } else {
            layoutId = R.layout.upcoming_match_new_day_list_item;
        }

        convertView = LayoutInflater.from(getContext()).inflate(layoutId, parent, false);

        TextView date = convertView.findViewById(R.id.date);
        TextView time = convertView.findViewById(R.id.time);
        TextView homeTeam = convertView.findViewById(R.id.homeTeam);
        TextView awayTeam = convertView.findViewById(R.id.awayTeam);

        if (layoutId == R.layout.upcoming_match_new_day_list_item) {
            date.setText(parsedDate);
        }
        time.setText(parsedTime);
        homeTeam.setText(match.getHomeTeam());
        awayTeam.setText(match.getAwayTeam());

        return convertView;
    }
}

