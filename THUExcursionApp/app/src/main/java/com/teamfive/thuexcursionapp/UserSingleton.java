package com.teamfive.thuexcursionapp;

import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

public class UserSingleton {
    private static UserSingleton instance = null;
    private String username;
    private String password;
    private String userType;
    private String userID;
    private String userNumber;
    private String email;

    private UserSingleton(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    /**
     *
     * @author Joey T. Mafukidze
     *
     * Double Locking Thread Safe Implementation of the User class to ensure that only one thread will access
     * a particular resource at a time.
     *
     * The double locking ensures that the overhead of the synchornized method is reduced.
     * @return instance
     */
    public static UserSingleton getInstance(){
        if(instance == null)
        synchronized (UserSingleton.class){
            if(instance == null) {
                instance = new UserSingleton();
            }
        }
        return instance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
