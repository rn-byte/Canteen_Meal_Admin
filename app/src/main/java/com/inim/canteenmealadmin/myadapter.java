package com.inim.canteenmealadmin;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapter extends FirebaseRecyclerAdapter<modelForRead,myadapter.myviewholder> {
    ConstraintLayout pL;


    public myadapter(@NonNull FirebaseRecyclerOptions<modelForRead> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull modelForRead model) {
        holder.t1.setText(model.getUser());
        holder.pL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(v.getContext(),ViewDetailActivity.class);
                i.putExtra("name",model.getUser());
                v.getContext().startActivity(i);
            }
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.staff_row,parent,false);

        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        TextView t1;
        ConstraintLayout pL;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.t1);
            pL=itemView.findViewById(R.id.pL);


        }
    }
}
