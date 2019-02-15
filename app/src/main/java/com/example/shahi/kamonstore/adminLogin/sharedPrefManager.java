package com.example.shahi.kamonstore.adminLogin;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by shahi on 07/02/2019.
 */

public class sharedPrefManager {
    private static final String shared_Pref = "My_shared_pref";
    private static sharedPrefManager mInstance;
    //to handle shared preference
    private Context mCtx;

    private sharedPrefManager(Context mCtx) {
        this.mCtx = mCtx;
    }

    public static synchronized sharedPrefManager getmInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new sharedPrefManager(mCtx);
        }
        return mInstance;
    }

   public void saveAdmin(String admin) {
        SharedPreferences sharedPref = mCtx.getSharedPreferences(shared_Pref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString("Username",admin);
        editor.putString("Password",admin);

        editor.apply();

    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(shared_Pref, Context.MODE_PRIVATE);
        return sharedPreferences.getString("Admin", null) != null;
    }

    //This is a method to checked the admin already logged in
    public loginModel getAdmin() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(shared_Pref, Context.MODE_PRIVATE);
        return new loginModel(
                sharedPreferences.getString("Username", null),
                sharedPreferences.getString("Password", null)
        );
    }

    public void clear() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(shared_Pref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}