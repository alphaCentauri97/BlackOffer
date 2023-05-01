package com.example.blackoffer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.example.blackoffer.Fragments.ExploreFragment;
import com.example.blackoffer.Fragments.RefineFragment;
import com.example.blackoffer.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        FragmentTransaction homeTransaction  = getSupportFragmentManager().beginTransaction();
        homeTransaction.replace(R.id.content,new RefineFragment());
        homeTransaction.commit();
        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.refine){
                        FragmentTransaction homeTransaction  = getSupportFragmentManager().beginTransaction();
                        homeTransaction.replace(R.id.content,new RefineFragment());
                        homeTransaction.commit();
                }
                else{
                    FragmentTransaction picTransaction  = getSupportFragmentManager().beginTransaction();
                    picTransaction.replace(R.id.content,new ExploreFragment());
                    picTransaction.commit();
                }
                return true;
            }
        });
        binding.toolbar.setNavigationIcon(R.drawable.nav_icon);

       binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.drawer.openDrawer(GravityCompat.START);
            }
        });
        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                binding.drawer.closeDrawer(GravityCompat.START);

                return true;
            }
        });

    }
}