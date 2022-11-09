package com.application.genius.view.multiplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.application.genius.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SearchActivity extends AppCompatActivity {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference myConnectionsRef = database.getReference("users/online");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
}