package com.example.footballresultsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.footballresultsapp";
    public String[] areaCodes = {"2001", "2002", "2014", "2015", "2019", "2021"};
    private ListView listView;
    private ArrayList<League> result = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listaview);

        for (String s : areaCodes) {
            makeRequest(s);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                League selected = result.get(position);
                String codeToPass = selected.getCompetitionID();
                Intent intent = new Intent(getApplicationContext(), StandingsActivity.class);
                intent.putExtra(EXTRA_MESSAGE, codeToPass);
                startActivity(intent);
            }
        });
    }

    public void makeRequest(String code) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.football-data.org/v2/competitions/" + code;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    /*
                    JSONArray jsonArray = response.getJSONArray("teams");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String league = object.getString("name");
                        result.add(league);
                    }*/

                    //näin saa yhden liigan
                    String leagueName = (String) response.get("name");
                    int competitionID = (Integer) response.get("id");
                    //Log.d("TAGI", competitionID);
                    League leagueToAdd = new League(leagueName, Integer.toString(competitionID));
                    result.add(leagueToAdd);

                } catch (Exception e) {
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
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-Auth-Token", "5e25ad658d7c4577aec218810b77e937");
                return params;
            }
        };
        queue.add(jsonObjectRequest);
    }

    public void setupView() {
        final ArrayAdapter<League> adapter;
        adapter = new LeagueArrayAdapter(this, result);
        listView.setAdapter(adapter);
    }
}