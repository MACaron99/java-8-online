package org.example.calculator;

import org.example.entity.City;
import org.example.entity.Neighbour;
import org.example.writer.InputWriter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Calculator {

    public static List<City> cities = new ArrayList<>();

    public static void start() {
        try {
            System.out.println();
            System.out.println("Program SHORT ROUTE FINDER");
            System.out.println("Welcome to the program SHORT ROUTE FINDER. Program for finding the shortest route between 15 cities of Germany");
            System.out.println();
            InputWriter.write();
            Scanner scanner = new Scanner(new File("input.txt"));
            PrintWriter writer = new PrintWriter("output.txt");
            if (!scanner.hasNextInt()) stop();
            int cityNumber = scanner.nextInt();
            for (int i = 0; i < cityNumber; i++) {
                City city = new City();
                if (scanner.hasNextInt()) stop();
                String name = scanner.next();
                if (!scanner.hasNextInt()) stop();
                int neighbourNumber = scanner.nextInt();
                List<Neighbour> neighbours = new ArrayList<>();
                for (int j = 0; j < neighbourNumber; j++) {
                    Neighbour neighbour = new Neighbour();
                    if (!scanner.hasNextInt()) stop();
                    int index = scanner.nextInt();
                    if (!scanner.hasNextInt()) stop();
                    int cost = scanner.nextInt();
                    check(i + 1, index - 1, cost);
                    neighbour.setIndex(index);
                    neighbour.setCost(cost);
                    neighbours.add(neighbour);
                }
                city.setName(name);
                city.setNeighbours(neighbours);
                cities.add(city);
            }
            if (!scanner.hasNextInt()) stop();
            int nextInt1 = scanner.nextInt();
            for (int i = 0; i < nextInt1; i++) {
                if (scanner.hasNextInt()) stop();
                String startCity = scanner.next();
                if (scanner.hasNextInt()) stop();
                String endCity = scanner.next();
                int minCost = findMinimumCost(cities, startCity, endCity);
                writer.println(minCost);
            }
            if (scanner.hasNext()) stop();
            writer.close();
            System.out.println("Shortest route found");
        } catch (IOException e) {
            System.out.println("e " + e.getMessage());
        }
    }

    public static int findMinimumCost(List<City> cities, String start, String end) {
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> costs = new HashMap<>();
        for (City city : cities) {
            costs.put(city.getName(), Integer.MAX_VALUE);
        }
        queue.add(start);
        costs.put(start, 0);
        while (!queue.isEmpty()) {
            String currentCity = queue.poll();
            City currentCityObj = new City();
            for (City city : cities) {
                if (city.getName().equals(currentCity)) {
                    currentCityObj = city;
                }
            }
            for (Neighbour neighbour : currentCityObj.getNeighbours()) {
                String neighbourName = cities.get(neighbour.getIndex() - 1).getName();
                if (neighbourName != null) {
                    int cost;
                    cost = neighbour.getCost() + costs.get(currentCity);
                    if (cost < costs.get(neighbourName)) {
                        costs.put(neighbourName, cost);
                        queue.add(neighbourName);
                    }
                }
            }
        }
        return costs.get(end);
    }

    public static void stop() {
        System.out.println("Invalid input options");
        delete(new File("input.txt"));
        delete(new File("output.txt"));
        System.exit(0);
    }

    public static void delete(File file) {
        if (file.exists()) {
            if (!file.delete()) {
                System.out.println("Error while deleting");
            }
        }
    }

    public static void check(int currentCityIndex, int neighbourIndex, int cost) {
        if (neighbourIndex >= 0 && neighbourIndex < cities.size()) {
            boolean found = false;
            for (Neighbour neighbour : cities.get(neighbourIndex).getNeighbours()) {
                if (neighbour.getIndex() == currentCityIndex && neighbour.getCost() == cost) {
                    found = true;
                    break;
                }
            }
            if (!found) stop();
        }
    }
}
