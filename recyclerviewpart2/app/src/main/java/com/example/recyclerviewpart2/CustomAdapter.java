package com.example.recyclerviewpart2;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//Create an adapter

/*
    Android uses adapters (from the Adapter class) to connect data with View items in a list.
    There are many different kinds of adapters available,
    and you can also write custom adapters. In this task you will create an adapter that associates
    your list of words with word list View items.
*/

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    // Storing your data in the adapter
    private Context context;
    private String[] animeName;
    private int[] animeImage;

    public CustomAdapter(Context context, String[] animeName, int[] animeImage) {
        this.context = context;
        this.animeName = animeName;
        this.animeImage = animeImage;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.animeName.setText(animeName[position]);
        holder.animeImage.setImageResource(animeImage[position]);
    }

    @Override
    public int getItemCount() {
        return animeName.length;
    }

    //Create the ViewHolder for the adapter
    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView animeImage;
        private TextView animeName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            animeImage = itemView.findViewById(R.id.anime_image);
            animeName = itemView.findViewById(R.id.anime_name);
        }
    }
}
