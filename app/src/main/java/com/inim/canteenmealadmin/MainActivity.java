package com.inim.canteenmealadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    public FragmentManager fragmentManager;
    FrameLayout frameLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        frameLayout = findViewById(R.id.framelayout);
        fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout, new AdminMainFragment()).addToBackStack(null).commit();

        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {

                    case R.id.noti:
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.framelayout, new AddNewNoticeFragment()).addToBackStack(null).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.menu:
                        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                        fragmentTransaction2.replace(R.id.framelayout, new AddMenuFragment()).addToBackStack(null).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.displaymenu:
                        FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
                        fragmentTransaction3.replace(R.id.framelayout, new DisplayMenuFragment()).addToBackStack(null).commit();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                    case R.id.vstaff:

                        Intent i = new Intent(getApplicationContext(), ViewActivity.class);
                        startActivity(i);
                        Toast.makeText(MainActivity.this, "staff is open", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.astaff:

                        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                        fragmentTransaction1.replace(R.id.framelayout, new AddNewStaffFragment()).addToBackStack(null).commit();

                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.dispNotice:
                        Intent in = new Intent(getApplicationContext(), NoticeDisplayActivity.class);
                        startActivity(in);
                        break;
                    case R.id.logout:
                        signout();
                        break;
                }

                return true;
            }


        });

    }

    private void signout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
