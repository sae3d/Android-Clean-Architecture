package com.msaeed.mobile.cleanapplication.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by msaeed on 1/5/2017.
 */

public class User implements Serializable {
    @SerializedName(ModelConstants.SERIALIZED_NAME_USER_NAME)
    private String userName;
    @SerializedName(ModelConstants.SERIALIZED_NAME_USER_IMAGE)
    private String userImage;
    @SerializedName(ModelConstants.SERIALIZED_NAME_USER_ID)
    private String userId;
    @SerializedName(ModelConstants.SERIALIZED_NAME_USER_TYPE)
    private String userType;
    @SerializedName(ModelConstants.SERIALIZED_NAME_USER_SYSTEM_ADMIN)
    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
}
