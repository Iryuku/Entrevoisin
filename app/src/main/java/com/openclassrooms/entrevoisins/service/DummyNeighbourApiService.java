package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }
    @Override
    public Neighbour getNeighbourById(int id) {
        return neighbours.get(id);
    }

    @Override
    public void changeNeighbourFavoriteStatus(Neighbour neighbour) {
        neighbours.get(neighbours.indexOf(neighbour)).setFavorites(!neighbour.isFavorites());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }
    @Override
    public List<Neighbour> getFavorisNeighbours() {
        List<Neighbour> favoriteNeighbors = new ArrayList<>();
        for (Neighbour n : neighbours) {
            if (n.isFavorites())
                favoriteNeighbors.add(n);
        }
        return favoriteNeighbors;
    }

}
