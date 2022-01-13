package com.inim.canteenmealadmin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMenuFragment extends Fragment {


    EditText foodIdET, foodNameET, foodPriceEt;
    Button menuBtn;
    FirebaseDatabase fd = FirebaseDatabase.getInstance();
    DatabaseReference ref = fd.getReference().child("menu");

    public AddMenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_menu, container, false);
        foodIdET = view.findViewById(R.id.foodIdET);

        foodNameET = view.findViewById(R.id.foodNameET);
        foodPriceEt = view.findViewById(R.id.foodPriceET);
        menuBtn = view.findViewById(R.id.menuBtn);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fId = foodIdET.getText().toString();
                String fName = foodNameET.getText().toString();
                int fPrice = Integer.parseInt(foodPriceEt.getText().toString());

                NewMenuDataHolder obj = new NewMenuDataHolder(fId, fName, fPrice);
                ref.child(fName).setValue(obj);
                Toast.makeText(getContext(), "Update Complete", Toast.LENGTH_SHORT).show();


            }
        });


        return view;
    }
}