package org.example.service;

import org.example.entity.Collection;

import java.util.UUID;

public class CollectionService {

    public Collection[] collections = new Collection[10];
    public int collectionNumber = 0;

    public void create(Collection collection) {
        if (collectionNumber == collections.length - 1) {
            Collection[] newCollections = new Collection[collections.length * 2];
            System.arraycopy(collections, 0, newCollections, 0, collections.length);
            collections = newCollections;
            add(collection);
        } else {
            add(collection);
        }
    }

    private void add(Collection collection) {
        collection.setId(UUID.randomUUID().toString());
        collections[collectionNumber] = collection;
        collectionNumber++;
    }

    public Collection[] findAll() {
        return collections;
    }

    public Collection findOne(String id) {
        for (Collection collection : collections) {
            if (collection.getId().equals(id)) {
                return collection;
            }
        }
        return null;
    }

    public Collection[] findMany(String[] ids) {
        Collection[] selections = new Collection[collectionNumber * collectionNumber];

        int number = 0;

        for (String id : ids) {
            for (int j = 0; j < collectionNumber; j++) {
                if (id.equals(collections[j].getId())) {
                    selections[number] = collections[j];
                    number++;
                }
            }
        }
        if (number > 0) {
            return selections;
        } else {
            return null;
        }
    }

    public void update(String id, Collection newCollection) {
        for (int i = 0; i < collectionNumber; i++) {
            if (collections[i].getId().equals(id)) {
                collections[i] = newCollection;
                return;
            }
        }
    }

    public void delete(Collection collection) {
        int count = 0;

        Collection[] newCollections = new Collection[10];

        for (int i = 0; i < collectionNumber; i++) {
            if (!collections[i].equals(collection)) {
                newCollections[count] = collections[i];
                count++;
            }
        }
        collections = newCollections;
        collectionNumber--;
    }
}
