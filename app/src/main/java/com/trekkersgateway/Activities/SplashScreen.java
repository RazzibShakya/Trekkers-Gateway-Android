package com.trekkersgateway.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.trekkersgateway.R;

public class SplashScreen extends AppCompatActivity {
    SharedPreferences preferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        preferences = getSharedPreferences("APP", MODE_PRIVATE);
        editor=preferences.edit();
        String val=preferences.getString("token", "");
        if(val.isEmpty()){
            final Intent intent = new Intent(SplashScreen.this, Login.class);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(intent);
                    finish();
                }
            },3000);
        }else{
            Intent intent1=new Intent(this,Dashboard.class);
            startActivity(intent1);
        }

    }
}