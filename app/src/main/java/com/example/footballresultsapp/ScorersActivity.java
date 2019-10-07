package com.example.footballresultsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

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
import java.util.Objects;

public class ScorersActivity extends AppCompatActivity {

    private ListView listView;
    private final ArrayList<Scorer> scorers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Top 10 scorers");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_scorers);
        Intent intent = getIntent();
        String competitionID = Objects.requireNonNull(intent.getExtras()).getString(MainActivity.EXTRA_MESSAGE);
        listView = findViewById(R.id.listViewScorers);
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

    private void getCompetition(String competitionID) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.football-data.org/v2/competitions/" + competitionID + "/scorers";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("scorers");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject scorerObject = jsonArray.getJSONObject(i);
                        JSONObject playerObject = scorerObject.getJSONObject("player");
                        String scorerName = playerObject.getString("name");
                        JSONObject teamObject = scorerObject.getJSONObject("team");
                        String teamName = teamObject.getString("name");
                        int scorerGoals = scorerObject.getInt("numberOfGoals");
                        Scorer scoreToAdd = new Scorer(scorerName, teamName, scorerGoals);
                        scorers.add(scoreToAdd);
                    }

                } catch (JSONException e) {
                    Log.d("Error", "Error loading Volley data!");
                }
                setupView();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", "Error loading Volley data!");
            }
        }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put("X-Auth-Token", "5e25ad658d7c4577aec218810b77e937");
                return params;
            }
        };
        queue.add(jsonObjectRequest);
    }

    public void setupView() {
        final ArrayAdapter<Scorer> adapter;
        adapter = new ScorerArrayAdapter(this, scorers);
        listView.setAdapter(adapter);
    }
}
