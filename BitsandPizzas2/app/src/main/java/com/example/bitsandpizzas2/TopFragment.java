package com.example.bitsandpizzas2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TopFragment extends Fragment {
    /* The difference between onCreateView and onViewCreated is

      oncreateView is used to inflate the fragment, on the otherhand
      Inflate the XML layout for the Fragment in this callback.
      The system calls this method to draw the Fragment UI for the first time.
      onViewCreated gets findViewById and calls a view (textview,imageview, edittext etc)
   */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_top, container, false);
    }
}