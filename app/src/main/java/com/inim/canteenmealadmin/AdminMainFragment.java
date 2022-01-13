package com.inim.canteenmealadmin;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;


public class AdminMainFragment extends Fragment implements View.OnClickListener {
CardView ongoingOrders,newOrders,pastOrders,addNotice,deleteNotice,allOrders;
FrameLayout frameLayout;
    Fragment fragment;
public AdminMainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_admin_main, container, false);
newOrders=view.findViewById(R.id.newOrders);
ongoingOrders=view.findViewById(R.id.ongoingOrders);
        pastOrders=view.findViewById(R.id.pastOrders);
        addNotice=view.findViewById(R.id.addNotice);
        deleteNotice=view.findViewById(R.id.deleteNotice);
        allOrders=view.findViewById(R.id.allOrders);
        frameLayout=view.findViewById(R.id.framelayout);

        newOrders.setOnClickListener(this);
        ongoingOrders.setOnClickListener(this);
        pastOrders.setOnClickListener(this);
        addNotice.setOnClickListener(this);
        deleteNotice.setOnClickListener(this);
        allOrders.setOnClickListener(this);




        return  view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.newOrders:
              fragment = new newOrderFragment();
                Toast.makeText(v.getContext(), "new order", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ongoingOrders:
                fragment = new AddMenuFragment();
                break;
            case R.id.pastOrders:

                fragment = new DisplayMenuFragment();
                break;
            case R.id.addNotice:
                fragment = new AddNewNoticeFragment();
                break;
            case R.id.deleteNotice:
                Intent i=new Intent(v.getContext(),NoticeDisplayActivity.class );
                startActivity(i);
               break;
            case R.id.allOrders:
                //fragment = new allOrderFragment();
                Intent i2=new Intent(v.getContext(),ViewActivity.class );
                startActivity(i2);
                break;
        }
FragmentTransaction tr= getParentFragmentManager().beginTransaction();
        tr.replace(R.id.framelayout,fragment).addToBackStack(null).commit();
    }
}