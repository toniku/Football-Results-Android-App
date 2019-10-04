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

public class UpcomingMatchesArrayAdapter extends ArrayAdapter<Match> {

    static final int VIEW_TYPE_COUNT = 1;
    static final int VIEW_TYPE = 2;

    public UpcomingMatchesArrayAdapter(Context context, ArrayList<Match> upcoming) {
        super(context, 0, upcoming);
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }


    @Override
    public int getItemViewType(int itemPosition) {
        Match match = getItem(itemPosition);
        return VIEW_TYPE;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    @Override
    public View getView(int itemPosition, @Nullable View convertView, @NonNull ViewGroup parent) {
        Match match = getItem(itemPosition);
        /*
        int earlier = 0;
        if(itemPosition > 0){
            int lasku = itemPosition +1;
            earlier = lasku;
        }

        Match earlierMatch = getItem(earlier);

*/
        int layoutId = 0;
        String winner = match.getWinner();
        String unparsedDate = match.getDate();
        String parsedDate = unparsedDate.substring(0,10);
        String parsedTime = unparsedDate.substring(11,16);
        //String earlierMatchDate = earlierMatch.getDate().substring(0,10);



        //if (convertView == null) {
           // if(earlierMatchDate.equals(parsedDate)){
                layoutId = R.layout.upcoming_match_list_item;
            //} else {
            //    layoutId = R.layout.upcoming_match_new_day_list_item;
            //}

        //}

        convertView = LayoutInflater.from(getContext()).inflate(layoutId, parent, false);

        TextView date = convertView.findViewById(R.id.date);
        TextView time = convertView.findViewById(R.id.time);
        TextView homeTeam = convertView.findViewById(R.id.homeTeam);
        TextView awayTeam = convertView.findViewById(R.id.awayTeam);

        date.setText(parsedDate);
        time.setText(parsedTime);
        homeTeam.setText(match.getHomeTeam());
        awayTeam.setText(match.getAwayTeam());

        return convertView;
    }
}

