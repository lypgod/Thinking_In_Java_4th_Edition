package com.lypgod.test.tij4.practices.Ch17_Containers.Practice25;//: containers/SimpleHashMap.java
// A demonstration hashed Map.

import com.lypgod.test.tij4.practices.Ch17_Containers.Countries;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;
    // You can't have a physical array of generics,
    // but you can upcast to one:
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<>();
        m.putAll(Countries.capitals(5));
        System.out.println(m);
        System.out.println(m.put("BENIN", "New York?"));
        System.out.println(m.put("BENIN", "Porto-Novo"));
        System.out.println(m.get("BENIN"));
        System.out.println(m.entrySet());
    }

    @Override
    public V put(K key, V value) {
        V oldValue;
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
            LinkedList<MapEntry<K, V>> bucket = buckets[index];
            bucket.add(pair);
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        if (buckets[index].size() > 0) {
            for (MapEntry<K, V> entry = bucket.get(0); entry != null; entry = entry.getNextEntry()) {
                if (entry.getKey().equals(key)) {
                    oldValue = entry.getValue();
                    entry.setValue(value);
                    return oldValue;
                }
            }
            bucket.add(pair);
            int i = bucket.indexOf(pair);
            if (i > 0) {
                bucket.get(i - 1).setNextEntry(pair);
            }
            return pair.getValue();
        }
        return null;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        }
        for (MapEntry<K, V> iPair : buckets[index]) {
            if (iPair.getKey().equals(key)) {
                return iPair.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            for (MapEntry<K, V> mpair : bucket) {
                set.add(mpair);
            }
        }
        return set;
    }
}