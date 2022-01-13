package com.inim.canteenmealadmin;

import android.graphics.Color;
import android.net.wifi.ScanResult;
import android.net.wifi.aware.IdentityChangedListener;
import android.util.Log;
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

import java.util.HashMap;

public class NewOrderAdapter extends FirebaseRecyclerAdapter<ModelForNewOrder, NewOrderAdapter.myViewHolder> {

    public NewOrderAdapter(@NonNull FirebaseRecyclerOptions<ModelForNewOrder> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull ModelForNewOrder model) {
        //String a = "hello";
        holder.dateTV.setText("Date: "+model.getDate());
        holder.tvOrder.setText("Food: "+model.getFood());
        holder.orderIdTV.setText("Order No.: "+model.getOrderId());
        holder.priceTV.setText("Price: "+model.getTotalPrice());
        holder.qtyTV.setText("Quantity: "+model.getQty());
        holder.totalPriceTV.setText("Total price: "+model.getTotalPrice());
        holder.nameTV.setText("User: "+model.getName());
        holder.phoneTV.setText("Phone No.: "+ model.getPhone());
        holder.statusTV.setText("Status: "+model.getStatus());
        holder.orderRemoveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Cart").child("order");
                reference.child(model.getOrderId()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(view.getContext(), "Delete completed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        if(model.getStatus().equals("Delivered")){
            holder.deliveredBTN.setText("Delivered");
            holder.deliveredBTN.setBackgroundColor(Color.GREEN);
        }
        holder.deliveredBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.orderRemoveBTN.setVisibility(View.VISIBLE);


                String selectedOId= model.getOrderId();
                String date= model.getDate();
                String food= model.getFood();
                String orderId=model.getOrderId();
                long price=model.getTotalPrice();
                String name= model.getName();
                String phone= model.getPhone();
                String status="Delivered";

                HashMap User =new HashMap();
                User.put("date",date);
                User.put("food",food);
                User.put("orderId",orderId);
                User.put("price",price);
                User.put("name",name);
                User.put("phone",phone);
                User.put("status",status);

                DatabaseReference dr=FirebaseDatabase.getInstance().getReference("Cart").child("order");
                dr.child(selectedOId).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        Toast.makeText(view.getContext(), "Delivered", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });


        Log.d("Demo", "data " + model.getQty());

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_for_new_order, parent, false);

        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView tvOrder, foodTV, orderIdTV, priceTV, qtyTV, totalPriceTV,dateTV,nameTV,phoneTV,statusTV;
        Button deliveredBTN,orderRemoveBTN;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTV=itemView.findViewById(R.id.dateTV);
            tvOrder = itemView.findViewById(R.id.tvOrder);
            orderIdTV = itemView.findViewById(R.id.orderIdTV);
            priceTV = itemView.findViewById(R.id.priceTV);
            qtyTV = itemView.findViewById(R.id.qtyTV);
            totalPriceTV = itemView.findViewById(R.id.totalPriceTV);
            nameTV=itemView.findViewById(R.id.nameTV);
            phoneTV=itemView.findViewById(R.id.phoneTV);
            statusTV=itemView.findViewById(R.id.statusTV);
            deliveredBTN=itemView.findViewById(R.id.deliveredBTN);
            orderRemoveBTN=itemView.findViewById(R.id.orderRemoveBTN);
            orderRemoveBTN.setVisibility(View.INVISIBLE);
        }
    }
}
