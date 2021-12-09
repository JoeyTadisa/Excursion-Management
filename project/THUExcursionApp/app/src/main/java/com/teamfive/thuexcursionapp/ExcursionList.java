package com.teamfive.thuexcursionapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.widget.Toolbar;

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
//initialize the main toolbar
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);


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
                                int id = jsonResponse.getInt("id");
                                String description = jsonResponse.getString("description");
                                //String dateAdded = jsonResponse.getString("");
                                int maxParticipants = jsonResponse.getInt("max_participants");
                                String regDeadline = jsonResponse.getString("reg_deadline");
                                String deregDeadline = jsonResponse.getString("dereg_deadline");
                                String meetingDetails = jsonResponse.getString("meeting_details");
                                String title = jsonResponse.getString("title");
                                excursionArrayList.add(new ExcursionEntry(id, description, maxParticipants,
                                        regDeadline, deregDeadline, meetingDetails, title));

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
   @Override
   public boolean onOptionsItemSelected( MenuItem item) {
//menu option account, goes to the account Info page
        int id =item.getItemId();
        if(id== R.id.studentaccount){
            Intent accountIntent = new Intent(ExcursionList.this, AccountInfo.class);
            startActivity(accountIntent);
            return false;
        }
        //menu option about us, directs to wiki page about the app
       if(id== R.id.aboutus) {
           Intent aboutusIntent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://github.com/JoeyTadisa/Excursion-Management/wiki/Welcome-to-the-THU-excursion-App!"));
           startActivity(aboutusIntent);
           return false;
       }

       return super.onOptionsItemSelected(item);
   }




    }



