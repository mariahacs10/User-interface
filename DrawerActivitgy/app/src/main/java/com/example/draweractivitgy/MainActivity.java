package com.example.draweractivitgy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

  // Video i followed:https://www.youtube.com/watch?v=fAXeq5F-CjI


    //Define your variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    //This will determine if you selected an item or not
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this sets your reousrce values
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        //This going to tell if the drawer is open or closed
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.menu_Open, R.string.close_menu);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        //going to sync and make sure everything is up to data
        actionBarDrawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        //This will alow you to click the navigation bar
        navigationView.setNavigationItemSelectedListener(item -> {

            //this is going to display something in the long cat
            //everytime you click for example ther home button
            //it will pop up in the log cat
            switch(item.getItemId())
            {
                case R.id.nav_home:
                    Log.i("MENU_DRAWER_TAG", "Home item is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.nav_search:
                    Log.i("MENU_DRAWER_TAG", "Search item is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.nav_users:
                    Log.i("MENU_DRAWER_TAG", "User item is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.nav_profile:
                    Log.i("MENU_DRAWER_TAG", "Profile item is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.nav_settings:
                    Log.i("MENU_DRAWER_TAG", "Settings item is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.nav_share:
                    Log.i("MENU_DRAWER_TAG", "Share item is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.nav_donate:
                    Log.i("MENU_DRAWER_TAG", "Donate item is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;

                case R.id.nav_logout:
                    Log.i("MENU_DRAWER_TAG", "Logout item is clicked");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
            }
            //Then when your done return true
            return true;
        });



    }
}