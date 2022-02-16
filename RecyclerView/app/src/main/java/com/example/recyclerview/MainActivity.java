package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<User> usersList;
    private RecyclerView recyclerView;
    private recyclerAdapter.RecyclerViewClickListener listener;

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
        setOnClickListener();
        recyclerAdapter adapter = new recyclerAdapter(usersList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener()
    {
        listener = new recyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int postion) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                intent.putExtra("username", usersList.get(postion).getUsername());
                startActivity(intent);
            }
        };
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
        usersList.add(new User("Kakashi"));
        usersList.add(new User("Gon"));
        usersList.add(new User("Gon"));
        usersList.add(new User("Kurapika"));
        usersList.add(new User("Kurapika"));

    }
}