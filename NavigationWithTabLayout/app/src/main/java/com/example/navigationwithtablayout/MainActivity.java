package com.example.navigationwithtablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Attach the ViewPager to the TabLayout 4
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        //This creates a viewpager
        ViewPager2 viewPager2 = findViewById(R.id.pager);

        //Attach the AdapterDemo to the ViewPager
        AdapterDemo adapterDemo = new AdapterDemo(getSupportFragmentManager(), getLifecycle());
        //Attach the FragmentPagerAdapter to the ViewPager. pg 494
        viewPager2.setAdapter(adapterDemo);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText("Tab" +(position+1));
        }).attach();
    }
}