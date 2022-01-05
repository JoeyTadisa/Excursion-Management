package com.teamfive.thuexcursionapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
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

/**
 * @author Joey T. Mafukidze
 *
 *
 *  Manages the login of the excursion management application on the Android implementation
 */
public class LoginActivity extends AppCompatActivity {
    EditText usernameInput;
    EditText passwordInput;
    Button loginButton;

    SharedPreferences rememberUser;

    /**
     *
     *
     * @param savedInstanceState The savedInstanceState is a reference to a Bundle object that is
     *                           passed into the onCreate method of every Android Activity.
     *                           Activities have the ability, under special circumstances,
     *                           to restore themselves to a previous state using the data stored in this bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        rememberUser = getSharedPreferences("login",MODE_PRIVATE);
        if(rememberUser.getBoolean("logged_IN",false)==true){
            goToExcursionList();
        }

        initializeListeners();

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        /*
         * When the sign in button is pressed, the data entered in the EditText fields is passed through the API's
         * endpoint and a JSON response is used to verify that the user exists in the database.
         */
        loginButton.setOnClickListener(v -> {
            ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(false);
            progressDialog.setTitle("Verifying Credentials...");
            progressDialog.setMessage("Just a moment!");
            progressDialog.show();
            String url = "http://10.0.2.2:9191/login/" + usernameInput.getText().toString().trim() + "/" + passwordInput.getText().toString().trim();
            StringRequest credentialsRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                /**
                 * Creates a request using the user-given credentials and validate the details with what is stored in the external remote database.
                 *
                 * @param response - The JSON response return after a call to the Excursion Management Spring API
                 */
                @Override
                public void onResponse(String response) {
                    try {
                        // after success response from server pass the response into an object and extract the resources that we require to confirm login - not the most secure
                        JSONObject studentUser = new JSONObject(response);
                        String username = studentUser.getString("username");
                        String password = studentUser.getString("password");
                        String userType = studentUser.getString("user_type");
                        String userID = studentUser.getString("id");
                        String matriculation_no = studentUser.getString("user_no");

                        /*UserSingleton studentInstance = UserSingleton.getInstance();
                        studentInstance.setPassword(password);
                        studentInstance.setUserID(userID);
                        studentInstance.setUsername(username);
                        studentInstance.setUserType(userType);
                        studentInstance.setUserNumber(matriculation_no);*/

                        SharedPreferences.Editor editor = rememberUser.edit();
                        editor.clear();
                        editor.putString("user_id", userID);
                        editor.putString("user_no", matriculation_no);
                        editor.apply();

                        //check input text fields
                        if (validatePassword() && validateUsername()) {
                            //acceptance criteria: the user must be of type student and have the correct credentials
                            if (usernameInput.getText().toString().trim().equals(username) && passwordInput.getText().toString().trim().equals(password) && userType.equals("s")) {
                                progressDialog.dismiss();
                                Toast.makeText(LoginActivity.this, "Successfully logged in", Toast.LENGTH_LONG).show();
                                rememberUser.edit().putBoolean("logged_IN", true).apply();
                                goToExcursionList();
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(LoginActivity.this, "Wrong Credentials! Please verify your details and try again.", Toast.LENGTH_LONG).show();
                            }
                        }
                        }catch(Exception e){
                            progressDialog.dismiss();
                            e.printStackTrace();
                        }
                }
            }, error -> Toast.makeText(LoginActivity.this, "Some error occurred -> "+ error, Toast.LENGTH_LONG).show()){
                /**
                 * Token-based authorisation
                 *
                 * @deprecated
                 * @return studentCredentials - students login details
                 * @throws AuthFailureError in the event an authorisation token fails isn't received this exception should be thrown
                 */
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
        View scanLink = findViewById(R.id.scanLogin);
        scanLink.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, ScanLoginActivity.class)));
    }

    /**
     *  Intent to start the main excursion list activity
     */
    public void goToExcursionList(){
        Intent startExcursionList = new Intent(LoginActivity.this,ExcursionList.class);
        startActivity(startExcursionList); //start the excursion list activity.
    }

    /**
     * Checks whether the input field is empty and returns a boolean value
     *
     * @return true - when all the the input criteria have been matched
     */
    private boolean validateUsername(){
        if(TextUtils.isEmpty((this.usernameInput.getText().toString().trim()))){
            this.usernameInput.setError("Username cannot be empty");
            this.usernameInput.requestFocus();
            return false;
        }else{
        return true;
        }
    }

    /**
     * Checks whether the input field is empty and returns a boolean value
     *
     * @return true - when all the the input criteria have been matched
     */
    private boolean validatePassword(){
        if(TextUtils.isEmpty((this.passwordInput.getText().toString().trim()))){
            this.passwordInput.setError("Username cannot be empty");
            this.passwordInput.requestFocus();
            return false;
        }else {
            return true;
        }
    }

    /**
     * Initialises the button and Edittext field listeners
     */
    private void initializeListeners(){
        usernameInput = findViewById(R.id.email);
        passwordInput = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
    }
}