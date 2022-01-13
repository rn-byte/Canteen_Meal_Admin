package com.inim.canteenmealadmin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class NoticeDisplayActivity extends AppCompatActivity {
    RecyclerView noticeDisplayRV;
    MyAdapterForNoticeDisplay adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_display);
        noticeDisplayRV=findViewById(R.id.noticeDisplayRV);
        noticeDisplayRV.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<noticeModelForRead> options=new FirebaseRecyclerOptions.Builder<noticeModelForRead>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("notice"),noticeModelForRead.class ).build();
        adapter=new MyAdapterForNoticeDisplay(options);
        noticeDisplayRV.setAdapter(adapter);

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