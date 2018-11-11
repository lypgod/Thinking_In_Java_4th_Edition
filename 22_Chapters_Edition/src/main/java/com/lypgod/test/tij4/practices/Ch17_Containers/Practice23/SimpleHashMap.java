package com.lypgod.test.tij4.practices.Ch17_Containers.Practice23;//: containers/SimpleHashMap.java
// A demonstration hashed Map.

import com.lypgod.test.tij4.practices.Ch17_Containers.Countries;

import java.util.*;

public class SimpleHashMap<K, V> implements Map<K, V> {
    // Choose a prime number for the hash table
    // size, to achieve a uniform distribution:
    static final int SIZE = 997;
    // You can't have a physical array of generics,
    // but you can upcast to one:
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];
    private KeySet keys = new KeySet();

    public static void main(String[] args) {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.putAll(Countries.capitals(3));
        System.out.println("map = " + map);
        System.out.println("map.entrySet(): " + map.entrySet());
        System.out.println("map.keySet(): " + map.keySet());
        System.out.println("map.values() = " + map.values());
        System.out.println("map.isEmpty(): " + map.isEmpty());
        System.out.println("map.containsKey(\"ALGERIA\"): " + map.containsKey("ALGERIA"));
        System.out.println("map.containsValue(\"Algiers\"): " + map.containsValue("Algiers"));
        System.out.println("map.get(\"ALGERIA\"): " + map.get("ALGERIA"));
        System.out.println("map.remove(\"ALGERIA\"): " + map.remove("ALGERIA"));
        System.out.println("After map.remove(\"ALGERIA\"), map.containsKey(\"ALGERIA\"): " + map.containsKey("ALGERIA"));
        System.out.println(" and map.get(\"ALGERIA\"): " + map.get("ALGERIA"));
        System.out.println(" and map: = " + map);
        map.clear();
        System.out.println("After map.clear(), map = " + map);
        System.out.println(" and map.isEmpty(): " + map.isEmpty());
        map.putAll(Countries.capitals(3));
        System.out.println("After map.putAll(Countries.capitals(3)), map = " + map);
        SimpleHashMap<String, String> map2 = new SimpleHashMap<>();
        map2.putAll(Countries.capitals(4));
        System.out.println("After map2.putAll(Countries.capitals(4)), map2 = " + map2);
        System.out.println(" and map.equals(map2): " + map.equals(map2));
        map2.remove("BOTSWANA");
        System.out.println("After map2.remove(\"BOTSWANT\"), map.equals(map2): " + map.equals(map2));
        map.entrySet().clear();
        System.out.println("After map.entrySet().clear, map = " + map);
        map.putAll(Countries.capitals(3));
        System.out.println("After map.putAll(Countries.capitals(3)), map = " + map);
        map.keySet().clear();
        System.out.println("After map.keySet().clear(), map = " + map);
    }

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }

    @Override
    public int size() {
        int result = 0;
        for (LinkedList bucket : buckets)
            if (bucket != null)
                result += bucket.size();
        return result;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            return false;
        for (MapEntry<K, V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return true;
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket != null)
                for (MapEntry<K, V> iPair : bucket)
                    if (iPair.getValue().equals(value))
                        return true;
        }
        return false;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            return null;
        for (MapEntry<K, V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null)
                continue;
            for (MapEntry<K, V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }

    @Override
    public void clear() {
        for (LinkedList<MapEntry<K, V>> bucket : buckets)
            if (bucket != null)
                bucket.clear();
    }

    private int firstNonEmptyBucket() {
        if (buckets.length < 1)
            return -1;
        for (int j = 0; j < buckets.length; j++)
            if (buckets[j] != null)
                return j;
        return -1;
    }

    private int start(int i) {
        int first = this.firstNonEmptyBucket();
        if (i < first)
            return -1;
        if (i == first)
            return 0;
        int result = 0;
        for (int j = first; j < i; j++)
            if (buckets[j] != null)
                result += buckets[j].size();
        return result;
    }

    private int end(int i) {
        int first = this.firstNonEmptyBucket();
        if (i < first)
            return -1;
        return start(i) + ((buckets[i] == null) ? 0 : buckets[i].size());
    }

    @Override
    public Set<K> keySet() {
        return keys;
    }

    @Override
    public Collection<V> values() {
        HashSet<V> vals = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket != null)
                for (MapEntry<K, V> iPair : bucket)
                    vals.add(iPair.getValue());
        }
        return vals;
    }

    @Override
    public V remove(Object key) {
        V v = null;
        if (this.get(key) != null) {
            int index = Math.abs(key.hashCode()) % SIZE;
            for (MapEntry<K, V> iPair : buckets[index])
                if (iPair.getKey().equals(key)) {
                    v = iPair.getValue();
                    int i = buckets[index].indexOf(iPair);
                    buckets[index].remove(i);
                    break;
                }
        }
        return v;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> me : m.entrySet())
            this.put(me.getKey(), me.getValue());
    }

    private class KeySet extends AbstractSet<K> {
        public int size() {
            return SimpleHashMap.this.size();
        }

        public Iterator<K> iterator() {
            return new Iterator<K>() {
                private int index = -1;

                public boolean hasNext() {
                    return index < SimpleHashMap.this.size() - 1;
                }

                public K next() {
                    ++index;
                    for (int j = 0; j < SIZE; j++) {
                        if ((start(j) <= index) && (index < end(j)))
                            return buckets[j].get(index - start(j)).getKey();
                    }
                    return null;
                }

                public void remove() {
                    for (int j = 0; j < SIZE; j++)
                        if (start(j) <= index && index < end(j))
                            buckets[j].remove(index - start(j));
                    index--;
                }
            };
        }
    }
}