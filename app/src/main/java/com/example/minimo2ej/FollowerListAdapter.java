package com.example.minimo2ej;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.minimo2ej.responses.Follower;

import java.util.List;

public class FollowerListAdapter extends RecyclerView.Adapter<FollowerListAdapter.ViewHolder>{

    private List<Follower> followerList;
    private Context context;


    public FollowerListAdapter( Context context){
        this.context = context;
    }

    public List<Follower> getFollowerList() {
        return followerList;
    }

    public void setFollowerList(List<Follower> followerList) {
        this.followerList = followerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.follower_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.followerName.setText(followerList.get(position).getLogin());
        Glide.with(this.context).load(followerList.get(position).getAvatar_url()).into(holder.followerImage);
    }

    @Override
    public int getItemCount() {
        return followerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView followerImage;
        TextView followerName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            followerImage = (ImageView)itemView.findViewById(R.id.followerPicture);
            followerName = (TextView)itemView.findViewById(R.id.followerId);

        }
    }
}
