package com.lypgod.test.tij4.practices.Ch17_Containers.Practice12;//: containers/AssociativeArray.java
// Associates keys with values.

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public static void main(String[] args) {
        System.out.println("------------- AssociativeArray --------------");
        AssociativeArray<String, String> map = new AssociativeArray<>(6);
        try {
            map.put("sky", "blue");
            map.put("grass", "green");
            map.put("ocean", "dancing");
            map.put("tree", "tall");
            map.put("earth", "brown");
            map.put("sun", "warm");
            map.put("extra", "object"); // Past the end
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many objects!");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));
        System.out.println("------------- HashMap --------------");
        Map<String, String> hsahMap = new HashMap<>(6);
        try {
            hsahMap.put("sky", "blue");
            hsahMap.put("grass", "green");
            hsahMap.put("ocean", "dancing");
            hsahMap.put("tree", "tall");
            hsahMap.put("earth", "brown");
            hsahMap.put("sun", "warm");
            hsahMap.put("extra", "object"); // Past the end
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many objects!");
        }
        System.out.println(hsahMap);
        System.out.println(hsahMap.get("ocean"));
        System.out.println("------------- TreeMap --------------");
        Map<String, String> treeMap = new TreeMap<>();
        try {
            treeMap.put("sky", "blue");
            treeMap.put("grass", "green");
            treeMap.put("ocean", "dancing");
            treeMap.put("tree", "tall");
            treeMap.put("earth", "brown");
            treeMap.put("sun", "warm");
            treeMap.put("extra", "object"); // Past the end
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many objects!");
        }
        System.out.println(treeMap);
        System.out.println(treeMap.get("ocean"));
        System.out.println("------------- TreeMap --------------");
        Map<String, String> linkedHashMap = new LinkedHashMap<>(6);
        try {
            linkedHashMap.put("sky", "blue");
            linkedHashMap.put("grass", "green");
            linkedHashMap.put("ocean", "dancing");
            linkedHashMap.put("tree", "tall");
            linkedHashMap.put("earth", "brown");
            linkedHashMap.put("sun", "warm");
            linkedHashMap.put("extra", "object"); // Past the end
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many objects!");
        }
        System.out.println(linkedHashMap);
        System.out.println(linkedHashMap.get("ocean"));
    }

    public void put(K key, V value) {
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{key, value};
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++)
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        return null; // Did not find key
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if (i < index - 1)
                result.append("\n");
        }
        return result.toString();
    }
}
