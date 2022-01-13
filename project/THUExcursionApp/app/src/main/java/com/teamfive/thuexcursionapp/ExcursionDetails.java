package com.teamfive.thuexcursionapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * @author Patrik Hanzséros
 * ExcursionDetails class
 */

public class ExcursionDetails extends AppCompatActivity {

//initialize Button
    Button registerButton;
    int id;
    String dateOfBook;
    SharedPreferences userId;
    String stringUserId;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excursion_details);
        CreateNotificationChannel();

        /**
         * By clicking on registerButton, the user goes to RegistrationCompleted Activity by creating a new intent
         */
        registerButton = findViewById(R.id.registerButton);
   //creating an Intent for the notification
        Intent notificationIntent= new Intent(this, RegistrationCompleted.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent. FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
   //create a Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"THUExcursionsApp")
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle("Registration completed")
                .setContentText("Thank you for your registration!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        registerButton.setOnClickListener(v -> {
            bookPost();
            Intent intent = new Intent(ExcursionDetails.this, RegistrationCompleted.class);
            startActivity(intent);
            notificationManager.notify(100,builder.build());

        });

        /**
         * @param intent Get the intent when clicked on an excursion in ExcursionList
         * @param excursionEntry will include the ExcursionEntry object which was passed with Parcelable
         */
        Intent intent = getIntent();
        ExcursionEntry excursionEntry = intent.getParcelableExtra("Example item");

        /**
         * @param description get description out of object
         * @param maxParticipants get maximum participants out of object
         * @param meetingLocation get meeting location out of object
         * @param title get title out of object
         * @param dateOfExcursion get date of excursion out of object & later overwrite with merging
         *                       dateDaySubstring & dateTimeSubstring
         * @param dateDaySubstring substring to get only the day without unnecessary signs
         * @param dateTimeSubstring substring to get only the time without unnecessary signs
         * @param regDeadline get registration deadline out of object & later overwrite with merging
         *                    regDaySubstring & regTimeSubstring
         * @param regDaySubstring substring to get only the day without unnecessary signs
         * @param regTimeSubstring substring to get only the time without unnecessary signs
         * @param deregDeadline get deregistration deadline out of object & later overwrite with merging
         *                    deregDaySubstring & deregTimeSubstring
         * @param deregDaySubstring substring to get only the day without unnecessary signs
         * @param deregTimeSubstring substring to get only the time without unnecessary signs
         * @param destination get destination out of object
         * @param fee get fee out of object
         * @param stringFee make string of double to be able to show it in textview
         */
        String description = excursionEntry.getDescription();
        int maxParticipants = excursionEntry.getMaxParticipants();
        String meetingLocation = excursionEntry.getMeetingDetails();
        String title = excursionEntry.getTitle();

        String dateOfExcursion = excursionEntry.getDateOfExcursion();
        String dateDaySubstring = dateOfExcursion.substring(0, 10);
        String dateTimeSubstring = dateOfExcursion.substring(11, 19);
        dateOfExcursion = dateDaySubstring + " " + dateTimeSubstring;

        String regDeadline = excursionEntry.getRegDeadline();
        String regDaySubstring = regDeadline.substring(0, 10);
        String regTimeSubstring = regDeadline.substring(11, 19);
        regDeadline = regDaySubstring + " " + regTimeSubstring;

        String deregDeadline = excursionEntry.getDeregDeadline();
        String deregDaySubstring = deregDeadline.substring(0, 10);
        String deregTimeSubstring = deregDeadline.substring(11, 19);
        deregDeadline = deregDaySubstring + " " + deregTimeSubstring;

        String destination = excursionEntry.getDestination();

        double fee = excursionEntry.getFee();
        String stringFee = Double.toString(fee);

        id = excursionEntry.getId();

        userId = getSharedPreferences("login", MODE_PRIVATE);
        stringUserId = userId.getString("user_no", "Default");

        //Toast.makeText(ExcursionDetails.this, dateOfBook, Toast.LENGTH_LONG).show();

        /**
         * Setting text views with the correct excursion details
         */
        TextView excursionTitle = findViewById(R.id.excursionTitle);
        excursionTitle.setText(title);

        TextView excursionDescriptionText = findViewById(R.id.excursionDescriptionText);
        excursionDescriptionText.setText(description);

        TextView excursionLocationText = findViewById(R.id.excursionLocationText);
        excursionLocationText.setText(meetingLocation);

        TextView excursionMaxPartText = findViewById(R.id.excursionMaxPartText);
        excursionMaxPartText.setText("" + maxParticipants);

        TextView excursionTimeText = findViewById(R.id.excursionTimeText);
        excursionTimeText.setText(dateOfExcursion);

        TextView registrationDeadlineText = findViewById(R.id.registrationDeadlineText);
        registrationDeadlineText.setText("registration deadline "+ regDeadline +
                "\nderegistration deadline " + deregDeadline);

        TextView excursionDestinationText = findViewById(R.id.excursionDestinationText);
        excursionDestinationText.setText(destination);

        TextView excursionFeeText = findViewById(R.id.excursionFeeText);
        excursionFeeText.setText(stringFee + "€");
    }

    private void CreateNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "StudentChannel";
            String description = "Channel for student notifications";
            NotificationChannel channel = new NotificationChannel("THUExcursionApp", "show RegistrationCompleted",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void bookPost(){
        String postUrl = "http://10.0.2.2:9191/bookAnExcursion";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JSONObject postData = new JSONObject();
        LocalDateTime now = LocalDateTime.now();
        String dateOfBook = now.toString();
        try {
            postData.put("date_booked", dateOfBook);
            postData.put("booked_by", stringUserId);
            postData.put("id_excursion", id);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, postUrl, postData,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(jsonObjectRequest);

    }


}