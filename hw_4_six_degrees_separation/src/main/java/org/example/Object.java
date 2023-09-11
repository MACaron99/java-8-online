package org.example;

import java.util.ArrayList;
import java.util.List;

class Object { // ну так собі назва классу))) я б не рекомендував використовувати назви для класів, якщо ці назви вже зарезервовані
    private int id;
    private List<Object> connections;

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