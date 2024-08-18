package org.example;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;

public class Dictionary<K, V> {

    private final Hashtable<K, V> hashtable;

    public Dictionary() {
        this.hashtable = new Hashtable<>();
    }

    public int size() {
        return hashtable.size();
    }

    public boolean isEmpty() {
        return hashtable.isEmpty();
    }

    public boolean containsKey(K key) {
        return hashtable.containsKey(key);
    }

    public boolean containsValue(V value) {
        return hashtable.containsValue(value);
    }

    public V get(K key) {
        return hashtable.get(key);
    }

    public boolean put(K key, V value) {
        if (key != null && value != null) {
            hashtable.put(key, value);
            return true;
        }
        return false;
    }

    public boolean remove(K key) {
        return hashtable.remove(key) != null;
    }

    public boolean putAll(Dictionary<K, V> dictionary) {
        if (dictionary != null) {
            hashtable.putAll(dictionary.hashtable);
            return true;
        }
        return false;
    }

    public boolean clear() {
        hashtable.clear();
        return true;
    }

    public Set<K> keySet() {
        return hashtable.keySet();
    }

    public Collection<V> values() {
        return hashtable.values();
    }
}
