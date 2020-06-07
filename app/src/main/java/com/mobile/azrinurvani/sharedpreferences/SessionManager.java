package com.mobile.azrinurvani.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SHARED_PREF_NAME= "session";
    String SESSION_KEY = "session_user";

    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSession(User user){
        //save session when user logged in
        int id = user.getId();
        editor.putInt(SESSION_KEY,id).commit();
    }

    public int getSession(){
        //return user whose session is saved
        return sharedPreferences.getInt(SESSION_KEY,-1);

    }

    public void clear(){
        editor.putInt(SESSION_KEY,-1).commit();

    }

}
