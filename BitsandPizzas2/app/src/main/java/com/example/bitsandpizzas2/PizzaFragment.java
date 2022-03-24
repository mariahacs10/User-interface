package com.example.bitsandpizzas2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class PizzaFragment extends ListFragment {
    /* The difference between onCreateView and onViewCreated is

        oncreateView is used to inflate the fragment, on the otherhand
        Inflate the XML layout for the Fragment in this callback.
        The system calls this method to draw the Fragment UI for the first time.
        onViewCreated gets findViewById and calls a view (textview,imageview, edittext etc)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.pizzas));
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}