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

import java.util.Objects;

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
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

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
        TextView localisation = findViewById(R.id.localisation_name);
        localisation.setText(neighbour.getAddress());
        TextView phoneNumber = findViewById(R.id.phoneNumber);
        phoneNumber.setText(neighbour.getPhoneNumber());
        TextView facebook = findViewById(R.id.facebook);
        TextView aboutme = findViewById(R.id.aboutme_name);
        aboutme.setText(neighbour.getAboutMe());
        //TextView Name2 = findViewById(R.id.activity_neighbour_details_toolbar_txt);
        favoriteNeighbour = neighbour.isFavorites();
        Name.setText(name);
        getSupportActionBar().setTitle(name);

        FloatingActionButton fab = findViewById(R.id.fab);
        if (favoriteNeighbour) {
            fab.setImageDrawable(getDrawable(R.drawable.ic_star_black_24dp));
        } else {
            fab.setImageDrawable(getDrawable(R.drawable.ic_star_border_black_24dp));
        }


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!favoriteNeighbour) {
                    favoriteNeighbour = true;
                    fab.setImageDrawable(getDrawable(R.drawable.ic_star_black_24dp));
                } else {
                    favoriteNeighbour = false;
                    fab.setImageDrawable(getDrawable(R.drawable.ic_star_border_black_24dp));
                }
                mApiServices.changeNeighbourFavoriteStatus(neighbour);

            }
        });
    }

}
