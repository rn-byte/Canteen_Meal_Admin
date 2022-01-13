package com.inim.canteenmealadmin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddNewStaffFragment extends Fragment {

    EditText firstET,addressET,userET,lastEt,postET,phoneET,salaryET,emailIdET;
    Button saveStaffBtn;
    FirebaseDatabase fd=FirebaseDatabase.getInstance();
    DatabaseReference ref =fd.getReference().child("staff");
    public AddNewStaffFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_add_new_staff, container, false);
        firstET=view.findViewById(R.id.firstET);
        addressET=view.findViewById(R.id.addressET);
        userET=view.findViewById(R.id.userET);
        emailIdET=view.findViewById(R.id.emailIdET);
        lastEt=view.findViewById(R.id.lastEt);
        postET=view.findViewById(R.id.postET);
        phoneET=view.findViewById(R.id.phoneET);
        salaryET=view.findViewById(R.id.salaryET);
        saveStaffBtn=view.findViewById(R.id.saveStaffBtn);

        saveStaffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fN=firstET.getText().toString();
                String address=addressET.getText().toString();
                String lN=lastEt.getText().toString();
                String user=userET.getText().toString();
                String email=emailIdET.getText().toString();
                String post=postET.getText().toString();
                double phone=Double.parseDouble(phoneET.getText().toString());
                int salary=Integer.parseInt(salaryET.getText().toString());

                NewAddStaffDataHolder obj=new NewAddStaffDataHolder(fN,address,user,lN,email,post,phone,salary);
                ref.child(user).setValue(obj);
                Toast.makeText(getContext(), "New Staff Added", Toast.LENGTH_SHORT).show();
                firstET.setText("");
                lastEt.setText("");
                addressET.setText("");
                userET.setText("");
                emailIdET.setText("");
                postET.setText("");
                phoneET.setText("");
                salaryET.setText("");
            }
        });

        return view;
    }
}