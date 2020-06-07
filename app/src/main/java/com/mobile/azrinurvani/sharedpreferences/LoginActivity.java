package com.mobile.azrinurvani.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    SessionManager sessionManager;
    boolean isUserLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sessionManager = new SessionManager(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //check if user logged in-> move to main activity
        checkSession();
    }

    private void checkSession() {
        int userId = sessionManager.getSession();
        if (userId!=-1){
            //user id logged in and move to mainActivity
            moveToMainActivity();
        }else{
            //do nothing
        }
    }

    public void login(View view) {
        // 1. Login to App and save session of user
        User user = new User("Azri",1);
        sessionManager.saveSession(user);

        // 2. Move to MainActivity
        moveToMainActivity();
    }

    private void moveToMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
