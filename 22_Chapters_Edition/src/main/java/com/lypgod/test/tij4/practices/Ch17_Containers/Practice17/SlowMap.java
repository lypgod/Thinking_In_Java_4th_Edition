package com.lypgod.test.tij4.practices.Ch17_Containers.Practice17;

import com.lypgod.test.tij4.practices.Ch17_Containers.Countries;

import java.util.*;


@SuppressWarnings("SuspiciousMethodCalls")
public class SlowMap<K, V> implements Map<K, V> {

    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();
    private EntrySet entries = new EntrySet();
    private Set<K> keySet = new KeySet();

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<>();
        m.putAll(Countries.capitals(15));
        System.out.println("m: " + m);
        System.out.println("m.get(\"BURUNDI\"): " + m.get("BURUNDI"));
        System.out.println("m.entrySet(): " + m.entrySet());
        System.out.println("m.keySet(): " + m.keySet());
        System.out.println("m.values() = " + m.values());
        System.out.println("Two different maps: ");
        SlowMap<String, String> m2 = new SlowMap<>();
        System.out.println("m.equals(m2): " + m.equals(m2));
        m2.putAll(Countries.capitals(15));
        System.out.println("Maps with same entries: ");
        System.out.println("m.equals(m2): " + m.equals(m2));
        m.clear();
        System.out.println("After m.clear(), m.isEmpty(): " + m.isEmpty() + ", m = " + m);
        m2.keySet().clear();
        System.out.println("After m2.keySet().clear(), m2.isEmpty(): " + m2.isEmpty() + ", m2 = " + m2);
    }

    @Override
    public Set<K> keySet() {
        return keySet;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return entries;
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return this.entrySet().isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    public V get(Object key) {
        if (!keys.contains(key)) {
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public V put(K key, V value) {
        V oldValue = get(key); // The old value or null
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else {
            values.set(keys.indexOf(key), value);
        }
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        V v = this.get(key);
        int i = keys.indexOf(key);
        keys.remove(i);
        values.remove(i);
        return v;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> me : m.entrySet()) {
            this.put(me.getKey(), me.getValue());
        }
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public Collection<V> values() {
        return values;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SlowMap) {
            if (this.entrySet().equals(((SlowMap) obj).entrySet())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.entrySet().hashCode();
    }

    @Override
    public String toString() {
        return this.entrySet().toString();
    }

    private class KeySet extends AbstractSet<K> {
        @Override
        public int size() {
            return keys.size();
        }

        @Override
        public Iterator<K> iterator() {
            return new Iterator<K>() {
                private int index = -1;

                @Override
                public boolean hasNext() {
                    return index < keys.size() - 1;
                }

                @Override
                public K next() {
                    ++index;
                    return keys.get(index);
                }

                @Override
                public void remove() {
                    keys.remove(index--);
                }
            };
        }

    }

    private class EntrySet extends AbstractSet<Entry<K, V>> {
        @Override
        public int size() {
            return keys.size();
        }

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                private int index = -1;

                @Override
                public boolean hasNext() {
                    return index < keys.size() - 1;
                }

                @Override
                @SuppressWarnings("unchecked")
                public Entry<K, V> next() {
                    int i = ++index;
                    return new MapEntry(keys.get(i), values.get(i));
                }

                @Override
                public void remove() {
                    keys.remove(index);
                    values.remove(index--);
                }
            };
        }
    }
}
