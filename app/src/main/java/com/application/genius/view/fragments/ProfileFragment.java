package com.application.genius.view.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.application.genius.R;
import com.application.genius.model.User;
import com.application.genius.util.AdapterListRank;
import com.application.genius.view.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Objects;

public class ProfileFragment extends Fragment {

    Button signOut;
    View root;
    private TextView fullName, email, username;
    private FirebaseDatabase database;
    private FirebaseAuth auth;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        dataSnapshot();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_profile, container, false);
        signOut = root.findViewById(R.id.signOut);

        fullName = root.findViewById(R.id.textViewFullName);
        email = root.findViewById(R.id.textViewEmail);
        username = root.findViewById(R.id.textViewUserName);

        signOut.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            signOut();
        });
        return root;
    }

    public void signOut() {
        startActivity(new Intent(getContext(), LoginActivity.class));
        requireActivity().finish();
    }

    public void dataSnapshot() {
            database.getReference().child("users").child(Objects.requireNonNull(auth.getCurrentUser()).getUid()).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    User user = snapshot.getValue(User.class);
                    fullName.setText(user.getFullName());
                    email.setText(user.getEmail());
                    username.setText(user.getUsername());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
    }
}