package com.inim.canteenmealadmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MyAdapterForNoticeDisplay extends FirebaseRecyclerAdapter<noticeModelForRead,MyAdapterForNoticeDisplay.MyViewHolder> {

    public MyAdapterForNoticeDisplay(@NonNull FirebaseRecyclerOptions<noticeModelForRead> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull  MyViewHolder holder, int position, @NonNull  noticeModelForRead model) {

        holder.tvNId.setText(model.getnId());

        holder.tvND.setText(model.getDateTime());

        holder.tvNM.setText(model.getnMsg());
        holder.delNoticeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference("notice");
                reference.child(model.getnId()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(v.getContext(), "Delete completed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.notice_row,parent,false);
        return new MyViewHolder(view);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNM,tvNT,tvND,tvNId,t1;
        Button delNoticeBtn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.t1);
            tvNId=itemView.findViewById(R.id.tvMI);
            tvND=itemView.findViewById(R.id.tvMN);
            tvNM=itemView.findViewById(R.id.tvMP);
            delNoticeBtn=itemView.findViewById(R.id.delNoticeBtn);

        }
    }
}
