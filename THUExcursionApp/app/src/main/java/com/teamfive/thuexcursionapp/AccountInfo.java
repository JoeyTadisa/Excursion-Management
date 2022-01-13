package com.teamfive.thuexcursionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class AccountInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);

        findViewById(R.id.delete_botton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(AccountInfo.this)
                        .setTitle("Delete")
                        .setMessage("Are you sure you want to delete your account?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }) .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    }

                }).show();

                //initialize the  toolbar for the account activity
        Toolbar toolbar = findViewById(R.id.account_toolbar);
        setSupportActionBar(toolbar);
//to create an arrow in the toolbar that takes you back to the main screen.)
        ActionBar myActionBar = getSupportActionBar();
        if (myActionBar != null) {

            myActionBar.setDisplayHomeAsUpEnabled(true);

        }

    }





});

    }
}
