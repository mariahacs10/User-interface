package com.example.recyclweviewq;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Create the RecyclerView in the Activity
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    private int[] animeImage = {R.drawable.glitterynaruto, R.drawable.nicesasuke,
            R.drawable.bro, R.drawable.dontbemean,  R.drawable.ahyas,R.drawable.wavingkaka, R.drawable.hurt, R.drawable.idkwut,
            R.drawable.chains, R.drawable.yasqueen, R.drawable.leviboi,};

    List<String> animeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animeList = new ArrayList<>();

        //// Get a handle to the RecyclerView.
        recyclerView = findViewById(R.id.recyclerView);
        // Create an adapter and supply the data to be displayed.
        recyclerAdapter = new RecyclerAdapter(animeList, animeImage);

        //This is the divider that is going to divide each section
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        animeList.add("Naruto");
        animeList.add("Sasuke");
        animeList.add("Sakura");
        animeList.add("Gaara");
        animeList.add("Rock Lee");
        animeList.add("Kakashi");
        animeList.add("Gon");
        animeList.add("Killua");
        animeList.add("Kurapika");
        animeList.add("Hisoka");
        animeList.add("Levi");

        // Connect the adapter with the RecyclerView.
        recyclerView.setAdapter(recyclerAdapter);

    }
}