package com.teamfive.thuexcursionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Patrik Hanzséros
 * ExcursionDetails class
 */

public class ExcursionDetails extends AppCompatActivity {


    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.excursion_details);

        /**
         * By clicking on registerButton, the user goes to RegistrationCompleted Activity by creating a new intent
         */
        registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExcursionDetails.this, RegistrationCompleted.class);
            startActivity(intent);
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
}