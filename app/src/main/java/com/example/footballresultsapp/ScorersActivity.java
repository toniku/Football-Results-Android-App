package com.example.footballresultsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class ScorersActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Scorer> scorers = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorers);

        Intent intent = getIntent();
        String competitionID = intent.getExtras().getString(MainActivity.EXTRA_MESSAGE);
        listView = findViewById(R.id.listViewScorers);
        getCompetition(competitionID);
        Log.d("ScorersActivity", competitionID);
    }

    private void getCompetition(String competitionID) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.football-data.org/v2/competitions/" + competitionID + "/scorers";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d("jorse",  response.toString());

                try {
                    Log.d("jorse", "try");

                    JSONArray jsonArray = response.getJSONArray("scorers");
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    JSONArray tableArray = jsonObject.getJSONArray("player");
                    for (int i = 0; i < tableArray.length(); i++) {

                        Log.d("jorse", "for");

                        JSONObject scorerObject = tableArray.getJSONObject(i);

                        String scorerName = scorerObject.getString("name");

                        Scorer scoreToAdd = new Scorer(scorerName);
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
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-Auth-Token", "5e25ad658d7c4577aec218810b77e937");
                return params;
            }
        };
        queue.add(jsonObjectRequest);
    }

    public void setupView() {

        Log.d("jorse", "setupview");

        final ArrayAdapter<Scorer> adapter;
        adapter = new ScorerArrayAdapter(this, scorers);
        listView.setAdapter(adapter);
    }
}
