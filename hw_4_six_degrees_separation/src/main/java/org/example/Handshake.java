package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Handshake {
    private static final int NUM_OBJECTS = 36000;
    private static final int MAX_CONNECTIONS = 6;

    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= NUM_OBJECTS; i++) {
            objects.add(new Object(i));
        }

        for (Object obj : objects) {
            while (obj.getConnections().size() < MAX_CONNECTIONS) {
                Object randomObject = objects.get(random.nextInt(NUM_OBJECTS));
                if (randomObject != obj && !obj.getConnections().contains(randomObject)) {
                    obj.addConnection(randomObject);
                    randomObject.addConnection(obj);
                }
            }
        }

        System.out.println();
        System.out.println("Program - THEORY OF SIX HANDSHAKES");
        System.out.println("In this program, connections between 36000 objects are randomly formed so that the maximum distance between objects is 6 handshakes.");
        System.out.println("You can specify initial and the final objects between which the program needs to find the shortest path.");
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the number of the initial object (1-" + NUM_OBJECTS + "): ");
        int startId = scanner.nextInt();
        System.out.println("Please enter the number of the final object (1-" + NUM_OBJECTS + "): ");
        int endId = scanner.nextInt();

        Object startObject = objects.get(startId - 1);
        Object endObject = objects.get(endId - 1);

        int shortestPath = findShortestPath(startObject, endObject);
        if (shortestPath == -1) {
            System.out.println("There is no relationship between these objects");
        } else {
            System.out.println("Shortest path between " + startId + " and " + endId + ": " + shortestPath + " handshakes");
        }
    }

    private static int findShortestPath(Object start, Object end) {
        Queue<Object> queue = new LinkedList<>();
        boolean[] visited = new boolean[NUM_OBJECTS];

        queue.add(start);
        visited[start.getId() - 1] = true;

        int distance = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            distance++;

            for (int i = 0; i < levelSize; i++) {
                Object current = queue.poll();

                for (Object neighbor : current.getConnections()) {
                    if (neighbor == end) {
                        return distance;
                    }

                    int neighborId = neighbor.getId() - 1;
                    if (!visited[neighborId]) {
                        queue.add(neighbor);
                        visited[neighborId] = true;
                    }
                }
            }
        }

        return -1;
    }
}