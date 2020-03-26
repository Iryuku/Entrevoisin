package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public class DetailNeighbourActivity extends AppCompatActivity {
    Neighbour neighbour;
    boolean favoriteNeighbour;
    private NeighbourApiService mApiServices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_neighbour);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra("Neighbour");
        neighbour = gson.fromJson(strObj, Neighbour.class);
        String name= neighbour.getName();
        String Avatar= neighbour.getAvatarUrl();
        TextView Name = findViewById(R.id.person_name);
        Name.setText(name);
        mApiServices = DI.getNeighbourApiService();
        ImageView mAvatar =  findViewById(R.id.avatar_name);
        Glide.with(this)
                .load(neighbour.getAvatarUrl())
                .into(mAvatar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                   mApiServices.changeNeighbourFavoriteStatus(neighbour);
                    neighbour.setFavorites(!neighbour.isFavorites());
                    if (neighbour.isFavorites()) {
                        fab.setImageDrawable(getDrawable(R.drawable.ic_star_black_24dp));
                    } else {
                        fab.setImageDrawable(getDrawable(R.drawable.ic_star_white_24dp));
                    }
                }
        });
    }

}
