package com.example.footballresultsapp;

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

public class TeamArrayAdapter extends ArrayAdapter<Team> {

    private static final int VIEW_TYPE_COUNT = 1;
    private static final int VIEW_TYPE = 2;

    public TeamArrayAdapter(Context context, ArrayList<Team> items) {
        super(context, 0, items);
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }


    @Override
    public int getItemViewType(int itemPosition) {
        return VIEW_TYPE;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @NonNull
    @Override
    public View getView(int itemPosition, @Nullable View convertView, @NonNull ViewGroup parent) {
        Team team = getItem(itemPosition);

        if (convertView == null) {
            int layoutId = R.layout.team_list_item;
            convertView = LayoutInflater.from(getContext()).inflate(layoutId, parent, false);
        }
        TextView ranking = convertView.findViewById(R.id.team_position);
        TextView teamName = convertView.findViewById(R.id.team_name);
        TextView games = convertView.findViewById(R.id.team_games);
        TextView wins = convertView.findViewById(R.id.team_wins);
        TextView draws = convertView.findViewById(R.id.team_draws);
        TextView losses = convertView.findViewById(R.id.team_losses);
        TextView points = convertView.findViewById(R.id.team_points);

        ranking.setText(String.valueOf(Objects.requireNonNull(team).getRankingNumber()));
        teamName.setText(team.getTeamName());
        games.setText(String.valueOf(team.getPlayedGames()));
        wins.setText(String.valueOf(team.getWins()));
        draws.setText(String.valueOf(team.getDraws()));
        losses.setText(String.valueOf(team.getLosses()));
        points.setText(String.valueOf(team.getPoints()));
        return convertView;
    }
}
