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

public class MenuAdapter extends FirebaseRecyclerAdapter<NewMenuDataHolder,MenuAdapter.MyMenuViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MenuAdapter(@NonNull FirebaseRecyclerOptions<NewMenuDataHolder> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyMenuViewHolder holder, int position, @NonNull NewMenuDataHolder model) {

        holder.tvMI.setText(model.getFoodId());

        holder.tvMN.setText(model.getFoodName());

        holder.tvMP.setText(""+model.getFoodPrice());
        holder.removeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference("menu");
                reference.child(model.getFoodName()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(view.getContext(), "Delete completed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    @NonNull
    @Override
    public MyMenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_row,parent,false);
        return new MyMenuViewHolder(view);    }

    public class MyMenuViewHolder extends RecyclerView.ViewHolder {
        TextView tvMP,tvNT,tvMN,tvMI,t1;
        Button removeBTN;

        public MyMenuViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMI=itemView.findViewById(R.id.tvMI);
            //delMenuBtn=itemView.findViewById(R.id.delMenuBtn);
            tvMN=itemView.findViewById(R.id.tvMN);
            tvMP=itemView.findViewById(R.id.tvMP);
            removeBTN=itemView.findViewById(R.id.removeBTN);
        }
    }
}
