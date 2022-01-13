package com.inim.canteenmealadmin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ViewActivity extends AppCompatActivity {
    RecyclerView rv;
    myadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        rv=findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<modelForRead> options=new FirebaseRecyclerOptions.Builder<modelForRead>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("staff"),modelForRead.class ).build();
        adapter=new myadapter(options);
        rv.setAdapter(adapter);
//        DatabaseReference reference=FirebaseDatabase.getInstance().getReference().child("staff");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull @NotNull DatabaseError error) {
//
//            }
//        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}