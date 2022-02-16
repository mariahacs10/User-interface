package com.example.bruh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.ViewHolder> {
    Context context;
    String[] animeNameList;
    String[] animeDescriptionList;
    int[] images;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView rowName;
        TextView rowDescription;
        ImageView rowImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rowName = itemView.findViewById(R.id.textView1);
            rowDescription = itemView.findViewById(R.id.textView2);
            rowImage = itemView.findViewById(R.id.imageView);
        }
    }

    public AnimeAdapter(Context context, String animeNameList[], String[] animeDescriptionList, int [] images)
    {
        this.context = context;
        this.animeNameList = animeNameList;
        this.animeDescriptionList = animeDescriptionList;
        this.images = images;
    }

    @NonNull
    @Override
    public AnimeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowName.setText(animeNameList[position]);
        holder.rowDescription.setText(animeDescriptionList[position]);
        holder.rowImage.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return animeNameList.length;
    }
}
