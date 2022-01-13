package com.inim.canteenmealadmin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class DisplayMenuFragment extends Fragment {
  RecyclerView dMRV;
  MenuAdapter adapter;


    public DisplayMenuFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_display_menu, container, false);
dMRV=view.findViewById(R.id.dMRV);
dMRV.setLayoutManager(new LinearLayoutManager(getContext()));
        FirebaseRecyclerOptions<NewMenuDataHolder> options=new FirebaseRecyclerOptions.Builder<NewMenuDataHolder>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("menu"),NewMenuDataHolder.class ).build();
        adapter=new MenuAdapter(options);
        dMRV.setAdapter(adapter);

        return  view;
    }
    @Override
    public void onStart() {

        super.onStart();
        adapter.startListening();

    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}