package com.example.footballresultsapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
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

public class ResultsActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Match> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        setTitle("Results");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        String competitionID = intent.getExtras().getString(MainActivity.EXTRA_MESSAGE);
        listView = findViewById(R.id.resultsListView);
        getCompetition(competitionID);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void getCompetition(String competitionID) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.football-data.org/v2/competitions/" + competitionID + "/matches";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("matches");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject teamObject = jsonArray.getJSONObject(i);
                        String date = teamObject.getString("utcDate");
                        String status = teamObject.getString("status");
                        JSONObject homeObject = teamObject.getJSONObject("homeTeam");
                        String homeTeam = homeObject.getString("name");
                        JSONObject awayObject = teamObject.getJSONObject("awayTeam");
                        String awayTeam = awayObject.getString("name");
                        if (status.contains("FINISHED")) {
                            JSONObject gameData = teamObject.getJSONObject("score");
                            String winner = gameData.getString("winner");
                            JSONObject score = gameData.getJSONObject("fullTime");
                            int homeGoals = score.getInt("homeTeam");
                            int awayGoals = score.getInt("awayTeam");
                            Match result = new Match(date, winner, homeTeam, awayTeam, homeGoals, awayGoals);
                            results.add(result);
                        } else {
                        }
                    }
                } catch (JSONException e) {
                    Log.d("Error", "Error loading Volley data!");
                }
                setupViewResults();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", "Error loading Volley data!");
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

    public void setupViewResults() {
        final ArrayAdapter<Match> adapter;
        adapter = new ResultsArrayAdapter(this, results);
        listView.setAdapter(adapter);
    }
}
