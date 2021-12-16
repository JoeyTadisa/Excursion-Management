package com.teamfive.thuexcursionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ExcursionDetails extends AppCompatActivity {

//initialize Button
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excursion_details);

        //By clicking on registerButton the user goes to RegistrationCompleted Activity
        registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExcursionDetails.this, RegistrationCompleted.class);
            startActivity(intent);
        });

        //Get the intent when clicked on an excursion in ExcursionList
        Intent intent = getIntent();
        ExcursionEntry excursionEntry = intent.getParcelableExtra("Example item");

        //Getting data into variables
        String description = excursionEntry.getDescription();
        int maxParticipants = excursionEntry.getMaxParticipants();
        String meetingLocation = excursionEntry.getMeetingDetails();
        String title = excursionEntry.getTitle();

        String dateOfExcursion = excursionEntry.getDateOfExcursion();
        String dateDaySubstring = dateOfExcursion.substring(0, 10);
        String dateTimeSubString = dateOfExcursion.substring(11, 19);
        dateOfExcursion = dateDaySubstring + " " + dateTimeSubString;

        String regDeadline = excursionEntry.getRegDeadline();
        String regDaySubstring = regDeadline.substring(0, 10);
        String regTimeSubString = regDeadline.substring(11, 19);
        regDeadline = regDaySubstring + " " + regTimeSubString;

        String deregDeadline = excursionEntry.getDeregDeadline();
        String deregDaySubstring = deregDeadline.substring(0, 10);
        String deregTimeSubString = deregDeadline.substring(11, 19);
        deregDeadline = deregDaySubstring + " " + deregTimeSubString;

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




    }
}