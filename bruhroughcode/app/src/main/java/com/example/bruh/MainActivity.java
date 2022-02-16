package com.example.bruh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutmanager;

    String animeNameList[] = {"Gon", "Hisoka", "Kurapika", "Killua",
            "Naruto", "Sasuke", "Sakura", "Kakashi", "Levi"};

    String animeNameDescription[] = {"Gon is sweet and powerful",
            "Hisoka Sussy and weird",
            "Kurapika Kind loving wants revenge",
            "Killua assisan friendly and SUSSY",
            "Naruto, Beastmode sussy funny",
            "Sasuke, Emo powerful kind?", "Sakura, Simp weak and graceful",
            "Kakashi, pwoerful funny sussy", "Levi.. idk powerful"};

    int  animeImages[] = {R.drawable.hurt, R.drawable.yasqueen, R.drawable.chains, R.drawable.idkwut, R.drawable.glitterynaruto,
      R.drawable.nicesasuke, R.drawable.bro, R.drawable.wavingkaka, R.drawable.leviboi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutmanager);
        programAdapter = new AnimeAdapter(this, animeNameList, animeNameDescription, animeImages);
        recyclerView.setAdapter(programAdapter);
    }
}