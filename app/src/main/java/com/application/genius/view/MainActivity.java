package com.application.genius.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.application.genius.R;
import com.application.genius.view.fragments.HomeFragment;
import com.application.genius.view.fragments.ProfileFragment;
import com.application.genius.view.fragments.StatisticsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;

    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    StatisticsFragment statisticsFragment = new StatisticsFragment();

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottomNavigationView);
        navigationView.setSelectedItemId(R.id.home);
        replace(homeFragment);


        navigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    replace(homeFragment);
                    break;
                case R.id.profile:
                    replace(profileFragment);
                    break;
                case R.id.statistics:
                    replace(statisticsFragment);
                    break;
            }
            return true;
        });
    }

    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, fragment);
        transaction.commit();
    }
}