package com.example.footballresultsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StandingsActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> result = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);

        Intent intent = getIntent();
        String competitionID = intent.getExtras().getString(MainActivity.EXTRA_MESSAGE);
        listView = findViewById(R.id.teams_listView);
        getCompetition(competitionID);
        Log.d("StandingsActivity", competitionID);
    }


    //EI TOIMI
    public void getCompetition(String competitionID) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.football-data.org/v2/competitions/" + competitionID + "/standings";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.d("getCompetition", response.toString());
                    JSONArray jsonArray = response.getJSONArray("table");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        int position = object.getInt("position");
                        String team = object.getString("name");
                        int playedGames = object.getInt("playedGames");
                        int wons = object.getInt("won");
                        //result.add(league);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                setupView();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-Auth-Token", "5e25ad658d7c4577aec218810b77e937");
                return params;
            }
        };
        queue.add(jsonObjectRequest);
    }

    public void setupView() {
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, result);
        listView.setAdapter(adapter);
    }
}
