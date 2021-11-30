package com.teamfive.thuexcursionapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class ExcursionList extends AppCompatActivity {

    String[] excursionTitlesForListview;
    ListView excursionListView;
    ArrayList<ExcursionEntry> excursionArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excursion_list);

        TextView tv = findViewById(R.id.json);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:9191/excursions";


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        tv.setText("Response is: "+ response.substring(0,500));
                        try{
                            JSONArray array = new JSONArray(response);
                            excursionTitlesForListview = new String[array.length()];
                            excursionArrayList = new ArrayList<>();
                            for(int i = 0; i < array.length(); i++) {
                                JSONObject jsonResponse = array.getJSONObject(i);
                                String description = jsonResponse.getString("description");
                                int maxParticipants = jsonResponse.getInt("max_participants");
                                String regDeadline = jsonResponse.getString("reg_deadline");
                                String deregDeadline = jsonResponse.getString("dereg_deadline");
                                String meetingDetails = jsonResponse.getString("meeting_details");
                                String title = jsonResponse.getString("title");
                                String dateOfExcursion = jsonResponse.getString("date_of_excursion");
                                excursionArrayList.add(new ExcursionEntry(description, maxParticipants,
                                        regDeadline, deregDeadline, meetingDetails, title, dateOfExcursion));

                                excursionTitlesForListview[i] = title;

                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                    getApplicationContext(),
                                    R.layout.excursion_listview_entry,
                                    R.id.singleEntryExcursion,
                                    excursionTitlesForListview
                            );
                            excursionListView = (ListView) findViewById(R.id.excursionListView);
                            excursionListView.setAdapter(adapter);


                            //Going to ExcursionDetails
                            excursionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                                    Intent excursionDetailsIntent = new Intent(ExcursionList.this, ExcursionDetails.class);
                                    excursionDetailsIntent.putExtra("Example item", excursionArrayList.get(pos));
                                    startActivity(excursionDetailsIntent);
                                }
                            });


                        } catch (JSONException e) {
                            e.printStackTrace();
                       }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        //10000 is the time in milliseconds adn is equal to 10 sec
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        // Add the request to the RequestQueue.
        queue.add(stringRequest);




    }
}
