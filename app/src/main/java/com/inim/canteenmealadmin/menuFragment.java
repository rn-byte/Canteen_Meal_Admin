package com.inim.canteenmealadmin;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class menuFragment extends Fragment implements View.OnClickListener {
 public    Fragment f=null;
  Button addMenuItem, addCategory;

    public menuFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_menu, container, false);
        addMenuItem=view.findViewById(R.id.addMenuItem);
        addCategory=view.findViewById(R.id.addCategory);
        addMenuItem.setOnClickListener(this);
        addCategory.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.addMenuItem:
                f = new AddNewItemFragment();
                break;
            case R.id.addCategory:
                f = new AddNewCatagoryFragment();
                break;
        }
        FragmentTransaction ft= getParentFragmentManager().beginTransaction();
        ft.replace(R.id.framelayout,f).commit();
    }
}