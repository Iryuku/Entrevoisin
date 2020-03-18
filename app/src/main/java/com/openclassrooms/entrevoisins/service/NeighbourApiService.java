package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    /**
     * Create a neighbour
     * @param neighbour
     */
    void createNeighbour(Neighbour neighbour);
    Neighbour getNeighbourById(int id);
    @Override
    public void changeNeighbourFavoriteStatus(Neighbour neighbour) {
        neighbours.get(neighbours.indexOf(neighbour)).setFavoriteStatus(!neighbour.isFavoriteStatus());
    }
    mFavFab.setOnClickListener(v -> {
        mApiService.changeNeighbourFavoriteStatus(mNeighbour);
        mNeighbour.setFavoriteStatus(!mNeighbour.isFavoriteStatus());
        if (mNeighbour.isFavoriteStatus()) {
            mFavFab.setImageDrawable(mStarYellow);
        } else {
            mFavFab.setImageDrawable(mStarBorderWhite);
        }
    });

}
