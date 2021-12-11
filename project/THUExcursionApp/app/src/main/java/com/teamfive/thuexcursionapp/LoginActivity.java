package com.teamfive.thuexcursionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    EditText usernameInput;
    EditText passwordInput;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usernameInput = findViewById(R.id.email);
        passwordInput = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        View scanLink = findViewById(R.id.scanLogin);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        Objects.requireNonNull(getSupportActionBar()).hide();
        /*
         * When the sign in button is pressed, the data entered in the EditText fields is passed through the API's
         * endpoint and a JSON response is used to verify that the user exists in the database.
         */
        loginButton.setOnClickListener(v -> {
            String url = "http://10.0.2.2:9191/login/" + usernameInput.getText() + "/" + passwordInput.getText();
            StringRequest credentialsRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try{
                        // after success response from server pass the response into an object and extract the resources that we require to confirm login - not the most secure
                        JSONObject studentUser = new JSONObject(response);
                        String username = studentUser.getString("username");
                        String password = studentUser.getString("password");
                        String userType = studentUser.getString("user_type");

                        //accepntance criteria: the user must be of type student and have the correct credentials
                        if(usernameInput.getText().toString().equals(username) && passwordInput.getText().toString().equals(password) && userType.equals("s")){
                            Toast.makeText(LoginActivity.this, "Successfully logged in", Toast.LENGTH_LONG).show();
                            Intent intentExcursion = new Intent(LoginActivity.this,ExcursionList.class);
                            startActivity(intentExcursion); //start the excursion list activity.
                        }else{
                            Toast.makeText(LoginActivity.this, "Wrong Credentials! Please verify your details and try again.", Toast.LENGTH_LONG).show();
                        }
                        }  catch (Exception e) {
                            e.printStackTrace();
                        }
                }
            }, error -> Toast.makeText(LoginActivity.this, "Some error occurred -> "+ error, Toast.LENGTH_LONG).show()){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError{
                    Map<String, String> studentCredentials = new HashMap<>();
                    studentCredentials.put("email", usernameInput.getText().toString());
                    studentCredentials.put("password", passwordInput.getText().toString());
                    return studentCredentials;
                } //throw an exception and print out the error message using a StringRequest error response listener
            };
            RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
            queue.add(credentialsRequest);
        });
        //invoke the scan login activity when the icon is clicked
        scanLink.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, ScanLoginActivity.class)));
    }
}