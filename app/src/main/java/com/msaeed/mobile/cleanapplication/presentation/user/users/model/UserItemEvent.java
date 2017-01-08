package com.msaeed.mobile.cleanapplication.presentation.user.users.model;

/**
 * Created by msaeed on 11/22/2016.
 */

public class UserItemEvent {

    private String userName;

    public UserItemEvent(String user) {
        this.userName = user;
    }

    public String getUserName() {
        return userName;
    }


}
