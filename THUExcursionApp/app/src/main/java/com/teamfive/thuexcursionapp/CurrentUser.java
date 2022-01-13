package com.teamfive.thuexcursionapp;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CurrentUser {
    List<String> userArray = new ArrayList();
    UserSingleton currentUser = UserSingleton.getInstance();

    public void setCurrentUser(UserSingleton currentUser) {
        this.currentUser = currentUser;
    }

    public UserSingleton getCurrentUser() {
        return currentUser;
    }

    public List<String> toUserList(){
        userArray.add(currentUser.getEmail());
        userArray.add(currentUser.getUsername());
        userArray.add(currentUser.getPassword());
        userArray.add(currentUser.getUserNumber());
        return userArray;
    }
}
