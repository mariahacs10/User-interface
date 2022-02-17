package com.example.recyclerviewlivingroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Create the RecyclerView in the Activity

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView();

    }

    private void initData() {

        userList = new ArrayList<>();

        userList.add(new ModelClass(R.drawable.bro, "Sakura", "5:59pm", "Oh My GosH SasUke", "_____________________"));

        userList.add(new ModelClass(R.drawable.chains, "Kurapika", "7:00pm", "I will get revenge of the phathom group", "_____________________"));

        userList.add(new ModelClass(R.drawable.glitterynaruto, "Naruto", "3:00pm", "I will be the greatest ninja BELIVE IT", "_____________________"));

        userList.add(new ModelClass(R.drawable.hurt, "Gon", "1:00:pm", "I will find my dad", "_____________________"));

        userList.add(new ModelClass(R.drawable.idkwut, "Killua", "9:00pm", "Huh- What- Oh yeah more coco robots ", "_____________________"));

        userList.add(new ModelClass(R.drawable.leviboi, "Levi", "9:00pm", "IMA MISTERY", "_____________________"));

        userList.add(new ModelClass(R.drawable.nicesasuke, "Sasuke", "9:00pm", "I will get revenge on my brother", "_____________________"));

        userList.add(new ModelClass(R.drawable.wavingkaka, "Kakashi", "9:00pm", "Bro i am just here cuz i have to", "_____________________"));

        userList.add(new ModelClass(R.drawable.yasqueen, "Hisoka", "9:00pm", "Do you wanna bet ?", "_____________________"));


    }

    private void initRecyclerView() {
        // Get a handle to the RecyclerView.
        recyclerView  = findViewById(R.id.recyclerView);
        // Give the RecyclerView a default layout manager.
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //// Create an adapter and supply the data to be displayed.
        adapter = new Adapter(userList);
        // Connect the adapter with the RecyclerView.
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}