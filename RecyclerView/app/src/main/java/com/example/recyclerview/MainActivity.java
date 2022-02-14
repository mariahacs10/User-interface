package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<User> usersList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        usersList = new ArrayList<>();

        setUserInfo();
        setAdapter();
    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(usersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setUserInfo() {
        usersList.add(new User("Killua"));
        usersList.add(new User("Hisoka"));
        usersList.add(new User("Kurapika"));
        usersList.add(new User("Gon"));
        usersList.add(new User("Naruto"));
        usersList.add(new User("Sakura"));
        usersList.add(new User("Sasuke"));
        usersList.add(new User("Kakashi"));
        usersList.add(new User("Levi"));
        usersList.add(new User("Naruto"));
        usersList.add(new User("Naruto"));
        usersList.add(new User("Naruto"));
        usersList.add(new User("Naruto"));
        usersList.add(new User("Naruto"));
        usersList.add(new User("Kakashi"));
        usersList.add(new User("Kakashi"));
        usersList.add(new User("Kakashi"));
        usersList.add(new User("Kakashi"));
        usersList.add(new User("Gon"));
        usersList.add(new User("Gon"));
        usersList.add(new User("Gon"));
        usersList.add(new User("Gon"));
        usersList.add(new User("Kurapika"));
        usersList.add(new User("Kurapika"));
        usersList.add(new User("Kurapika"));
        usersList.add(new User("Kurapika"));
        usersList.add(new User("Kurapika"));

    }
}