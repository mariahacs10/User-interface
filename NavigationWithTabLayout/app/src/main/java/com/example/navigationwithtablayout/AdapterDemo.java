package com.example.navigationwithtablayout;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

//This is going to do the adapter class
  /* The difference between onCreateView and onViewCreated is

        oncreateView is used to inflate the fragment, on the otherhand
        Inflate the XML layout for the Fragment in this callback.
        The system calls this method to draw the Fragment UI for the first time.
        onViewCreated gets findViewById and calls a view (textview,imageview, edittext etc)
     */
public class AdapterDemo extends FragmentStateAdapter {
    public AdapterDemo(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new DemoFragment();
        Bundle args = new Bundle();
        args.putString(DemoFragment.TITLE, "Tab"+(position+1));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
