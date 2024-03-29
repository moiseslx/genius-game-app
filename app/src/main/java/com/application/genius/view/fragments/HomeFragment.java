package com.application.genius.view.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.application.genius.R;
import com.application.genius.view.didactic.DidacticActivity;
import com.application.genius.view.game.PreferenceActivity;
import com.application.genius.view.multiplayer.SearchActivity;

public class HomeFragment extends Fragment {

    Button btnT, btnV, btnD, btnS;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        btnT = root.findViewById(R.id.btnT);
        btnV = root.findViewById(R.id.btnV);
        btnD = root.findViewById(R.id.btnD);
        btnS = root.findViewById(R.id.btnS);

        btnT.setOnClickListener(view -> startActivity(new Intent(getContext(), PreferenceActivity.class)));
        btnD.setOnClickListener(view -> startActivity(new Intent(getContext(), DidacticActivity.class)));
        btnV.setOnClickListener(view -> startActivity(new Intent(getContext(), SearchActivity.class)));
        return  root;
    }
}