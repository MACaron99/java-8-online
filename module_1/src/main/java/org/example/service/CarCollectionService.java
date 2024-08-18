package org.example.service;

import org.example.entity.CarCollection;

import java.util.UUID;

public class CarCollectionService {

    public CarCollection[] carCollections = new CarCollection[10];
    public int carCollectionNumber = 0;

    public void create(CarCollection carCollection) {
        if (carCollectionNumber == carCollections.length - 1) {
            CarCollection[] newCollections = new CarCollection[carCollections.length * 2];
            System.arraycopy(carCollections, 0, newCollections, 0, carCollections.length);
            carCollections = newCollections;
            add(carCollection);
        } else {
            add(carCollection);
        }
    }

    private void add(CarCollection carCollection) {
        carCollection.setId(UUID.randomUUID().toString());
        carCollections[carCollectionNumber] = carCollection;
        carCollectionNumber++;
    }

    public CarCollection findOneByCarId(String id) {
        for (CarCollection carCollection : carCollections) {
            if (carCollection.getCarId().equals(id)) {
                return carCollection;
            }
        }
        return null;
    }

    public CarCollection findOneByCollectionId(String id) {
        for (CarCollection carCollection : carCollections) {
            if (carCollection.getCollectionId().equals(id)) {
                return carCollection;
            }
        }
        return null;
    }

    public String[] findByCollectionId(String id) {
        int number = 0;

        String[] ids = new String[carCollectionNumber];

        for (int i = 0; i < carCollectionNumber; i++) {
            if (carCollections[i].getCollectionId().equals(id)) {
                ids[number] = carCollections[i].getCarId();
                number++;
            }
        }
        if (number > 0) {
            return ids;
        } else {
            return null;
        }
    }

    public String[] findByCarId(String id) {
        int number = 0;

        String[] ids = new String[carCollectionNumber];

        for (int i = 0; i < carCollectionNumber; i++) {
            if (carCollections[i].getCarId().equals(id)) {
                ids[number] = carCollections[i].getCollectionId();
                number++;
            }
        }
        if (number > 0) {
            return ids;
        } else {
            return null;
        }
    }

    public CarCollection findByCarAndCollectionId(String carId, String collectionId) {
        for (CarCollection carCollection : carCollections) {
            if (carCollection.getCarId().equals(carId)) {
                if (carCollection.getCollectionId().equals(collectionId)) {
                    return carCollection;
                }
            }
        }
        return null;
    }

    public void delete(CarCollection carCollection) {
        int count = 0;

        CarCollection[] newCarCollections = new CarCollection[10];

        for (int i = 0; i < carCollectionNumber; i++) {
            if (!carCollections[i].equals(carCollection)) {
                newCarCollections[count] = carCollections[i];
                count++;
            }
        }
        carCollections = newCarCollections;
        carCollectionNumber--;
    }
}
