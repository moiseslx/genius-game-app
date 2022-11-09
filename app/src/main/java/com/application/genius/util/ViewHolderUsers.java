package com.application.genius.util;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.genius.R;

public class ViewHolderUsers extends RecyclerView.ViewHolder {

    TextView username;
    TextView score;
    ImageView icon;

    public ViewHolderUsers(@NonNull View itemView) {
        super(itemView);

        username = itemView.findViewById(R.id.item_username);
        score = itemView.findViewById(R.id.item_score);
        icon = itemView.findViewById(R.id.item_icon);

    }
}
