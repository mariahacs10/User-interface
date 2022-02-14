package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/* This class is the adapter class

    Android uses adapters (from the Adapter class) to connect data with View items in a list.
    There are many different kinds of adapters available, and you can also write custom adapters.
    In this task you will create an adapter that associates your list of words with word list View items.

*/

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {

    private ArrayList<User> usersList;

    public recyclerAdapter(ArrayList<User> usersList)
    {
        this.usersList = usersList;
    }

    //This will be a inner class and it is a ViewHolder above
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView nameTxt;

        public MyViewHolder(final View view)
        {
            super(view);
            nameTxt = view.findViewById(R.id.textView4);
        }

    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String name = usersList.get(position).getUsername();
        holder.nameTxt.setText(name);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
