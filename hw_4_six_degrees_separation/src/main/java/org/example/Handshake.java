package org.example;

public class Handshake {
    public static void main(String[] args) {
        int numObjects = 6;
        Object[] objects = new Object[numObjects];

        for (int i = 0; i < numObjects; i++) {
            objects[i] = new Object(i + 1);
        }

        for (int i = 0; i < numObjects - 1; i++) {
            objects[i].sendMessage(objects[i + 1]);
        }
    }
}