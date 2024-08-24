package org.example;

import java.util.ArrayList;
import java.util.List;

class Object {

    private final int id;
    private final List<Object> connections;

    public Object(int id) {
        this.id = id;
        this.connections = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Object> getConnections() {
        return connections;
    }

    public void addConnection(Object obj) {
        connections.add(obj);
    }
}
