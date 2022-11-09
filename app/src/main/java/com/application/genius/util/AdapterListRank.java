package com.application.genius.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.genius.R;
import com.application.genius.model.User;

import java.util.List;

public class AdapterListRank extends RecyclerView.Adapter<ViewHolderUsers> implements Comparable <User>{

    List<User> userList;

    public AdapterListRank(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolderUsers onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);

        return new ViewHolderUsers(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderUsers holder, int position) {
        holder.username.setText(userList.get(position).getUsername());
        holder.score.setText(String.valueOf(userList.get(position).getScore()));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    @Override
    public int compareTo(User user) {
        return (user.getScore() - new User().getScore());
    }
}
