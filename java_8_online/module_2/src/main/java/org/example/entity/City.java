package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class City{

    private String name;
    private List<Neighbour> neighbours = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Neighbour> neighbours) {
        this.neighbours = neighbours;
    }
}
