package com.inim.canteenmealadmin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class newOrderFragment extends Fragment {
RecyclerView recyclerNeworder;
NewOrderAdapter adapter;


    public newOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_new_order, container, false);
        recyclerNeworder=view.findViewById(R.id.recyclerNeworder);
        recyclerNeworder.setLayoutManager(new LinearLayoutManager(getContext()));


//        FirebaseRecyclerOptions<ModelForNewOrder> options=new FirebaseRecyclerOptions.Builder<ModelForNewOrder>()
  //          .setQuery(FirebaseDatabase.getInstance().getReference().child("Cart").child("order"),ModelForNewOrder.class)
    //            .build();

        FirebaseRecyclerOptions<ModelForNewOrder> options=new FirebaseRecyclerOptions.Builder<ModelForNewOrder>()
                .setQuery(FirebaseDatabase.getInstance().getReference("Cart").child("order"),ModelForNewOrder.class ).build();


        adapter= new NewOrderAdapter(options);
        recyclerNeworder.setAdapter(adapter);


        return view;
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