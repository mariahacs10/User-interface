package com.example.recyclweviewq;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//Video link: https://www.youtube.com/watch?v=9rcrYFO1ogc

//Create A Adapter

/*
    Android uses adapters (from the Adapter class) to connect data with View items in a list.
    There are many different kinds of adapters available, and you can also write custom adapters.
    In this task you will create an adapter that associates your list of words with word list View items.
*/

public class RecyclerAdapter extends  RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String TAG = "RecyclerAdapter";

    //Storing your data in the adapter
    List<String> animeList;

    int images[];

    public RecyclerAdapter(List<String> animeList, int img[]) {
        this.animeList = animeList;
        this.images = img;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowCountTextView.setText(String.valueOf(position));
        holder.textView.setText(animeList.get(position));
        holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    //Create the ViewHolder for the adapter this is a inner class inside the adapter
    class ViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener
    {
        ImageView imageView;
        TextView textView, rowCountTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            rowCountTextView = itemView.findViewById(R.id.rowCountTextView);

            itemView.setOnClickListener(this);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    animeList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    return true;
                }
            });
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), animeList.get(getAdapterPosition()), Toast.LENGTH_LONG).show();
        }
    }
}
