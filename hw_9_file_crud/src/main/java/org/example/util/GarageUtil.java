package org.example.util;

import org.example.entity.BaseEntity;

import java.util.Collection;
import java.util.UUID;

public class GarageUtil {

    public static <E extends BaseEntity> String generateId(Collection<E> entities) {
        String id = UUID.randomUUID().toString();
        if (entities.stream().anyMatch(e -> e.getId().equals(id))) {
            generateId(entities);
        }
        return id;
    }
}
