package com.teamfive.thuexcursionapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author Patrik Hanzséros
 * ExcursionList class with the appropiate excursion_list.xml
 */

public class ExcursionList extends AppCompatActivity {

    String[] excursionTitlesForListview;
    ListView excursionListView;
    ArrayList<ExcursionEntry> excursionArrayList;
    Button refreshButton;

    /**
     * onCreate method is called when the Activity is running
     * @param savedInstanceState is always null running the Activity for the first time
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.excursion_list);
        fill();

        //initialize the main toolbar
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        /**
         * Whenever the refreshButton is clicked, fill() is called and refreshing the screen.
         * For test purposes: Toast shows it is clicked.
         */
        refreshButton = findViewById(R.id.refreshList);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fill();
                Toast.makeText(ExcursionList.this, "Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * fill() method contains everything to get and work on json & to show it on UI and called in onCreate()
     */
    private void fill(){
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:9191/approvedExcursions/true";


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            /**
                             * @param response has the JSON response from the API as a string
                             * @param array -> from String response we made a JSONArray
                             * @param excursionTitlesForListview Dynamic String array to store titles for ListView
                             * @param excursionArrayList to store ExcursionEntry objects in the ArrayList
                             */
                            JSONArray array = new JSONArray(response);
                            excursionTitlesForListview = new String[array.length()];
                            excursionArrayList = new ArrayList<>();
                            for(int i = 0; i < array.length(); i++) {
                                /**
                                 * @param array We go through the array
                                 * @param jsonResponse as JSONObject
                                 * @param description to get & store the value from jsonResponse by tag "description"
                                 * @param maxParticipants to get & store value from jsonResponse by tag "max_participants"
                                 * @param regDeadline to get & store value from jsonResponse by tag "reg_deadline"
                                 * @param deregDeadline to get & store value from jsonResponse by tag "dereg_deadline"
                                 * @param meetingDetails to get & store value from jsonResponse by tag "meeting_details"
                                 * @param title to get & store value from jsonResponse by tag "title"
                                 * @param dateOfExcursion to get & store value from jsonResponse by tag "date_of_excursion"
                                 * @param destionation to get & store value from jsonResponse by tag "destination"
                                 * @param fee to get & store value from jsonResponse by tag "excursion_fee"
                                 * @param id to get & store excursion id
                                 */
                                JSONObject jsonResponse = array.getJSONObject(i);

                                String description = jsonResponse.getString("description");
                                int maxParticipants = jsonResponse.getInt("max_participants");
                                String regDeadline = jsonResponse.getString("reg_deadline");
                                String deregDeadline = jsonResponse.getString("dereg_deadline");
                                String meetingDetails = jsonResponse.getString("meeting_details");
                                String title = jsonResponse.getString("title");
                                String dateOfExcursion = jsonResponse.getString("date_of_excursion");
                                String destination = jsonResponse.getString("destination");
                                double fee = jsonResponse.getDouble("excursion_fee");
                                int id = jsonResponse.getInt("id");

                                /**
                                 * add ExcursionEntry objects with values we got to excursionArrayList
                                 */
                                excursionArrayList.add(new ExcursionEntry(description, maxParticipants,
                                        regDeadline, deregDeadline, meetingDetails, title, dateOfExcursion,
                                        destination, fee, id));

                                /**
                                 * add titles to show it later on in excursionListView
                                 */
                                excursionTitlesForListview[i] = title;

                            }
                            /**
                             * @param adapter By setting the adapter (ArrayAdapter) to excursionListView, we
                             *                fill the listview with excursion titles to show them.
                             */
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
                                    /**
                                     * By click on a listview item, it starts a new Activity -> ExcursionDetails
                                     * Add extra details into the new intent by getting an ExcursionEntry object via position
                                     */
                                    Intent excursionDetailsIntent = new Intent(ExcursionList.this, ExcursionDetails.class);
                                    excursionDetailsIntent.putExtra("Example item", excursionArrayList.get(pos));
                                    startActivity(excursionDetailsIntent);
                                }
                            });

                        } catch (JSONException e) {
                            /**
                             * @exception JSONException
                             */
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });


        /**
         * 10000ms = 10sec
         * Set retry policy
         */
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                10000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));


        /**
         * @param stringRequest is added to queue "RequestQueue"
         */
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

       if(id==R.id.logout){
           logout();
           Intent startLoginActivity = new Intent(ExcursionList.this, LoginActivity.class);
           startActivity(startLoginActivity);
       }

        return super.onOptionsItemSelected(item);
    }
    public void logout(){
        SharedPreferences rememberUser = getSharedPreferences("login",MODE_PRIVATE);
        SharedPreferences.Editor editor = rememberUser.edit();
        editor.clear();
        editor.putBoolean("Logged_IN", false);
        editor.apply();
    }
}

