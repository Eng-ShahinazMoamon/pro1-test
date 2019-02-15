package com.example.shahi.kamonstore.adminLogin;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shahi on 26/01/2019.
 */

public class loginModel {

    private boolean error;
    private String message;
    @SerializedName("Username")
    private String user;
    @SerializedName("Password")
    private transient String password;

    public loginModel(String username, String password) {

    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
    public boolean isError() {
        return error;
    }

    public String getMessage(String s) {
        return message;
    }

}
