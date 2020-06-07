package com.mobile.azrinurvani.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(this);
    }

    public void logout(View view) {
        //this method will remove session and open login screen
        sessionManager.clear();
        moveToLogin();
    }

    private void moveToLogin() {
        Intent intent = new Intent(this,LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
