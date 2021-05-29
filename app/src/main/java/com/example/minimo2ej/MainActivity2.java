package com.example.minimo2ej;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.minimo2ej.io.MyApiAdapter;
import com.example.minimo2ej.io.MyApiService;
import com.example.minimo2ej.responses.Follower;
import com.example.minimo2ej.responses.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView ;
    FollowerListAdapter followerListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.USUARIO);
        ImageView usrImage = (ImageView)findViewById(R.id.userImage);
        TextView repos = (TextView)findViewById(R.id.repos);
        TextView following = (TextView)findViewById(R.id.following);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        followerListAdapter = new FollowerListAdapter(getApplicationContext());


        // Capture the layout's TextView and set the string as its text
        Call<UserResponse> call = MyApiAdapter.getApiService().getUserInfo(message);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse res = response.body();
                if(res != null){
                    //poner la imagen del usuario
                    Glide.with(getApplicationContext()).load(res.getAvatar_url()).into(usrImage);
                    //poner los repos y los seguidores
                    repos.setText(""+res.getPublic_repos());
                    following.setText(""+res.getFollowing());
                    //cargar la lista de seguidores


                    Call<List<Follower>> followers = MyApiAdapter.getApiService().getUserFollowers(message);
                    followers.enqueue(new Callback<List<Follower>>() {
                        @Override
                        public void onResponse(Call<List<Follower>> call, Response<List<Follower>> response) {
                           List<Follower> followerList = response.body();
                           loadData(followerList);
                           setAdapter();
                        }

                        @Override
                        public void onFailure(Call<List<Follower>> call, Throwable t) {

                        }
                    });

                }
                else{
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void loadData(List<Follower> list){
        followerListAdapter.setFollowerList(list);
    }
    public void setAdapter(){
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        this.recyclerView.setLayoutManager(manager);
        this.recyclerView.setAdapter(this.followerListAdapter);
    }
}