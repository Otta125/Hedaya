package com.app2gate.hedaya.UI.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app2gate.hedaya.Pojo.PostModel;
import com.app2gate.hedaya.R;

import java.util.ArrayList;
import java.util.List;

public class Home_adapter extends RecyclerView.Adapter<Home_adapter.PostViewHolder> {
    private List<PostModel> moviesList = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.titleTV.setText(moviesList.get(position).getTitle());
        holder.userTV.setText(moviesList.get(position).getUserId()+"");
        holder.bodyTV.setText(moviesList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void setList(List<PostModel> moviesList) {
        this.moviesList = moviesList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV, userTV, bodyTV;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            userTV = itemView.findViewById(R.id.userIDTV);
            bodyTV = itemView.findViewById(R.id.bodyTV);
        }
    }
}


