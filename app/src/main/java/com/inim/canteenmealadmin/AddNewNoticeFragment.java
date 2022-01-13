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

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class AddNewNoticeFragment extends Fragment {
    EditText noticeIdEt,noticeDateET,noticeTimeET,noticeMsgEt;
    FirebaseDatabase fd=FirebaseDatabase.getInstance();
    DatabaseReference ref =fd.getReference().child("notice");
    Button saveNoticeBtn;
    public AddNewNoticeFragment() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_new_notice, container, false);
        noticeIdEt=view.findViewById(R.id.noticeIdEt);

        noticeMsgEt=view.findViewById(R.id.noticeMsgEt);
        saveNoticeBtn=view.findViewById(R.id.saveNoticeBtn);
        saveNoticeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nId,DateTime,nMsg;
                 DateTime = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());

                nId=noticeIdEt.getText().toString();
           //     nDate=noticeDateET.getText().toString();
             //   nTime=noticeTimeET.getText().toString();
                nMsg=noticeMsgEt.getText().toString();
                NewNoticeDataHolder obj=new NewNoticeDataHolder(nId,DateTime,nMsg);
                ref.child(nId).setValue(obj);
                Toast.makeText(getContext(), "Notice uploaded!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}