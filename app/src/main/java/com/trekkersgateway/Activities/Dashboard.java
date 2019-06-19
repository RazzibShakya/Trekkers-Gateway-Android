package com.trekkersgateway.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.trekkersgateway.Model.User;
import com.trekkersgateway.R;


public class Dashboard extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        loadFragment(new Alltreks());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
getUser();
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_treks:
                fragment = new Alltreks();
                break;

            case R.id.navigation_forum:
                fragment = new Forum();
                break;

            case R.id.navigation_feed:
                fragment = new FeedPost();
                break;

            case R.id.navigation_profile:
                fragment = new Profile();
                break;

            case R.id.navigation_news:
                fragment = new NewsFrag();
                break;
        }

        return loadFragment(fragment);
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

public User getUser(){
    SharedPreferences shared=getSharedPreferences("APP",MODE_PRIVATE);
    Gson gson = new Gson();
    String json = shared.getString("userobj", "");
    User user = gson.fromJson(json, User.class);
    return user;
}

}
