package com.inim.canteenmealadmin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
import com.inim.canteenmealadmin.R;

import java.util.HashMap;


public class ViewDetailActivity extends AppCompatActivity {
    String n;
    TextView nameT, addressT,postT,numberT,salaryT,emailT,back,edit,deleteTV;
    String fn,ln,address,number,salary,post,email;
    DatabaseReference reference;
    EditText editFNET,editLNET,editAddressET,editSalaryET,editPostET,editNumberET,editEmailET;
    Button editUpdateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail);
        getIncommingValues();// getincommingValues() function call
        nameT = findViewById(R.id.nameT);
        addressT = findViewById(R.id.addressT);
        salaryT=findViewById(R.id.salaryT);
        postT=findViewById(R.id.postT);
        numberT=findViewById(R.id.numberT);
        emailT=findViewById(R.id.emailT);

//        TextView ttt=findViewById(R.id.ttt);
//        ttt.setVisibility(View.GONE);

        editFNET=findViewById(R.id.editFNET);
        editLNET=findViewById(R.id.editLNET);

        editAddressET=findViewById(R.id.editAddressET);
        editSalaryET=findViewById(R.id.editSalaryET);
        editPostET=findViewById(R.id.editPostET);
        editNumberET=findViewById(R.id.editNumberET);
        editEmailET=findViewById(R.id.editEmailET);
        editUpdateBtn=findViewById(R.id.editUpdateBtn);
        editUpdateBtn.setVisibility(View.INVISIBLE);
    editUpdateBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String newFirstName=editFNET.getText().toString();
        String newLastName=editLNET.getText().toString();
        String newAddress=editAddressET.getText().toString();
        String newSalary=editSalaryET.getText().toString();
        String newPost=editPostET.getText().toString();
        String newEmail=editEmailET.getText().toString();
        String  newNumber=editNumberET.getText().toString();

        HashMap User =new HashMap();

        User.put("fN",newFirstName);
        User.put("lN",newLastName);

        User.put("address",newAddress);
        User.put("salary",newSalary);
        User.put("post",newPost);
        User.put("email",newEmail);
        User.put("number",newNumber);

        DatabaseReference dr=FirebaseDatabase.getInstance().getReference("staff");
        dr.child(n).updateChildren(User).addOnCompleteListener(new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if(task.isComplete()){
                    editFNET.setText("");
                    editLNET.setText("");
                    editAddressET.setText("");
                    editPostET.setText("");
                    editNumberET.setText("");
                    editSalaryET.setText("");
                    editEmailET.setText("");
                    Toast.makeText(getApplicationContext(), "Update Sucessfull", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Update Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
});

        editEmailET.setVisibility(View.GONE);
        editNumberET.setVisibility(View.GONE);
        editPostET.setVisibility(View.GONE);
        editSalaryET.setVisibility(View.GONE);
        editFNET.setVisibility(View.GONE);
        editLNET.setVisibility(View.GONE);
        editAddressET.setVisibility(View.GONE);

        deleteTV=findViewById(R.id.deleteTV);
        deleteTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference=FirebaseDatabase.getInstance().getReference("staff");
                reference.child(n).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<Void> task) {
                        Toast.makeText(ViewDetailActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                    }
                })    ;
            }
        });


        search(n);



        edit= findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                TextView ttt=findViewById(R.id.ttt);
//                ttt.setVisibility(v.VISIBLE);
                editFNET.setVisibility(v.VISIBLE);
                editLNET.setVisibility(v.VISIBLE);
                editAddressET.setVisibility(v.VISIBLE);
                editEmailET.setVisibility(v.VISIBLE);
                editSalaryET.setVisibility(v.VISIBLE);
                editNumberET.setVisibility(v.VISIBLE);
                editEmailET.setVisibility(v.VISIBLE);
                editUpdateBtn.setVisibility(View.VISIBLE);
                DatabaseReference ref= FirebaseDatabase.getInstance().getReference("staff");
                ref.child(n).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String newFN,newLN,newAddress,newPost,newSalary,newEmail,newNumber;
                        editFNET.setText(fn);
                        editLNET.setText(ln);
                        editAddressET.setText(address);
                        editEmailET.setText(email);
                        editSalaryET.setText(salary);
                        editNumberET.setText(number);
                        editPostET.setText(post);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });

    }

    private void search(String n) {
        reference= FirebaseDatabase.getInstance().getReference("staff");
        reference.child(n).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                fn=String.valueOf(snapshot.child("fn").getValue());

                ln=String.valueOf(snapshot.child("lN").getValue());
                address=String.valueOf(snapshot.child("address").getValue());
                number=String.valueOf(snapshot.child("phone").getValue());
                salary=String.valueOf(snapshot.child("salary").getValue());
                post=String.valueOf(snapshot.child("post").getValue());
                email=String.valueOf(snapshot.child("email").getValue());




                nameT.setText(fn +" "+ln);
                addressT.setText(address);
                numberT.setText(number);
                salaryT.setText(salary);
                postT.setText(post);
                emailT.setText(email);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    private void getIncommingValues() {
        if(getIntent().hasExtra("name")){

            n=getIntent().getStringExtra("name");
            setText(n);//setText function call
        }

    }

    private void setText(String n) {
        TextView tv1;
        tv1=findViewById(R.id.tv1);
        tv1.setText(n);
    }
}