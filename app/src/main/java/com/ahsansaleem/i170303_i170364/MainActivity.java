package com.ahsansaleem.i170303_i170364;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements  BottomNavigationView.OnNavigationItemSelectedListener {


    BottomNavigationView bottomNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigator = findViewById(R.id.bottomNav);

        bottomNavigator.setOnItemSelectedListener(MainActivity.this);

//        bottomNavigator.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//                return true;
//            }
//        });



        loadFragment(new CallHistoryFragment());

    }


    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer,fragment) // Replace the frame layout (in main activity) with fragment
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.call_nav:
                fragment = new CallHistoryFragment();
                break;
            case R.id.cam_nav:
                fragment = new CallHistoryFragment();
                break;
            case R.id.chat_nav:
                fragment = new ChatFragment();
                break;
            case R.id.contact_nav:
                fragment = new ContactFragment();
                break;


        }
        return loadFragment(fragment);
    }



    // Add RecyclerView member
 //   private RecyclerView recyclerView;

//    @Override
//    public View onCreateView(
//            LayoutInflater inflater, ViewGroup container,
//            Bundle savedInstanceState
//    ) {
//
//        // Inflate the layout for this fragment
//
//
//
//
//        View view = inflater.inflate(R.layout.fragment_second, container, false);
//
//        // Add the following lines to create RecyclerView
//        recyclerView = view.findViewById(R.id.rcv);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        recyclerView.setAdapter(new RandomNumListAdapter(1234));
//
//        return view;
//    }
}
