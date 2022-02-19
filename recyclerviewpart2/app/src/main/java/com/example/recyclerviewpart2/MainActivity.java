package com.example.recyclerviewpart2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Create the RecyclerView in the Activity
    RecyclerView recyclerView;

    private CustomAdapter customAdapter;

    private String [] animeName = {"Naruto", "Sasuke", "Sakura", "Kakashi",
    "Gon"   , "Killua", "Kurapika", "Hisoka", "Levi"};

    private int[] animeImage = {R.drawable.glitterynaruto, R.drawable.nicesasuke,
    R.drawable.bro, R.drawable.wavingkaka, R.drawable.hurt, R.drawable.idkwut,
    R.drawable.chains, R.drawable.yasqueen, R.drawable.leviboi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create the RecyclerView in the Activity
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        //// Give the RecyclerView a default layout manager.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //// Create an adapter and supply the data to be displayed.
        customAdapter = new CustomAdapter(this, animeName, animeImage);

        //// Connect the adapter with the RecyclerView.
        recyclerView.setAdapter(customAdapter);

    }
}