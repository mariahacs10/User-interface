package com.example.recyclerviewlivingroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

//Create an adapter

/*
    Android uses adapters (from the Adapter class) to connect data with View items in a list.
    There are many different kinds of adapters available, and you can also write custom adapters.
     In this task you will create an adapter that associates your list of words with word list View items.

*/

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    //This is Storing your data in the adapter
    private List<ModelClass> userList;

    public Adapter( List<ModelClass> userList)
    {
        this.userList = userList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int resource = userList.get(position).getImageview1();
        String name = userList.get(position).getTextview1();
        String msg = userList.get(position).getTextview3();
        String time = userList.get(position).getTextview2();
        String line = userList.get(position).getDivider();

        holder.setData(resource, name, msg, time, line);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    //Create the ViewHolder for the adapter
    /*BTW this is inner  a class*/
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;
        private TextView textview2;
        private TextView textview3;
        private TextView divider;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview1);
            textView = itemView.findViewById(R.id.textview);
            textview2 = itemView.findViewById(R.id.textview2);
            textview3 = itemView.findViewById(R.id.textview3);
            divider = itemView.findViewById(R.id.divider);
        }

        public void setData(int resource, String name, String msg, String time, String line) {
            imageView.setImageResource(resource);

            textView.setText(name);
            textview3.setText(msg);
            textview2.setText(time);
            divider.setText(line);
        }
    }
}
