package com.lypgod.test.tij4.practices.Ch17_Containers.Practice24;

import java.util.*;

public class SimpleHashSet<E> implements Set<E> {
    static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    LinkedList<E>[] buckets = new LinkedList[SIZE];

    public static void main(String[] args) {
        SimpleHashSet<String> shs = new SimpleHashSet<>();
        System.out.println("New empty SimpleHashSet24, shs = " + shs);
        shs.add("hi");
        shs.add("there");
        System.out.println("After shs.add(\"hi\") and shs.add(\"there\"), shs = " + shs);
        List<String> list = Arrays.asList("you", "cutie", "pie");
        shs.addAll(list);
        System.out.println("After shs.addAll(list) (you, cutie, pie), shs = " + shs);
        System.out.println("shs.size() = " + shs.size());
        System.out.println("shs.contains(\"you\"): " + shs.contains("you"));
        System.out.println("shs.contains(\"me\"): " + shs.contains("me"));
        System.out.println("shs.containsAll(list): " + shs.containsAll(list));
        SimpleHashSet<String> shs2 = new SimpleHashSet<>();
        System.out.println("New empty shs2 = " + shs2);
        System.out.println("shs.containsAll(list): " + shs.containsAll(list));
        System.out.println("shs2.containAll(list): " + shs2.containsAll(list));
        System.out.println("shs.containsAll(shs2): " + shs.containsAll(shs2));
        System.out.println("shs2.containAll(shs2): " + shs2.containsAll(shs2));
        shs2.add("you");
        shs2.add("cutie");
        System.out.println("After shs2.add(\"you\"), shs2.add(\"cutie\"), shs2 = " + shs2);
        shs.removeAll(shs2);
        System.out.println("After shs.removeAll(shs2), shs = " + shs);
        System.out.println("shs.hashCode() = " + shs.hashCode());
        System.out.println("shs2 = " + shs2);
        System.out.println("shs2.isEmpty(): " + shs2.isEmpty());
        shs2.clear();
        System.out.println("After shs2.clear(), shs2.isEmpty(): " + shs2.isEmpty());
        List<String> list2 = Arrays.asList("hi", "there", "pie");
        shs2.addAll(list2);
        System.out.println("After shs2.addAll(list2) (hi, there, pie), shs2 = " + shs2);
        System.out.println("shs.equals(shs2): " + shs.equals(shs2));
        String[] sa = new String[3];
        shs.toArray(sa);
        System.out.print("After String[] sa = new String[3], shs.toArray(sa), sa holds: ");
        for (String aSa : sa) {

            System.out.print(aSa + " ");
        }
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
        return (this.size() == 0);
    }

    @Override
    public boolean contains(Object o) {
        int index = Math.abs(o.hashCode()) % SIZE;
        if (buckets[index] == null)
            return false;
        for (E e : buckets[index])
            if (e.equals(o))
                return true;
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = -1;

            public boolean hasNext() {
                return index < SimpleHashSet.this.size() - 1;
            }

            public E next() {
                ++index;
                for (int j = 0; j < SIZE; j++) {
                    if ((start(j) <= index) && (index < end(j)))
                        return buckets[j].get(index - start(j));
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

    @Override
    public Object[] toArray() {
        Object[] result = new Object[this.size()];
        Iterator<E> it = this.iterator();
        for (int i = 0; i < this.size(); i++)
            result[i] = it.next();
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        Iterator<E> it = this.iterator();
        for (int i = 0; i < this.size(); i++) {
            E x = it.next();
            try {
                a[i] = (T) x;
            } catch (ClassCastException e) {
                throw new RuntimeException(e);
            }
        }
        return a;
    }

    public String toString() {
        if (this.size() == 0)
            return "[]";
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (LinkedList<E> bucket : buckets) {
            if (bucket != null)
                for (E e : bucket)
                    s.append(String.valueOf(e)).append(" ");
        }
        s.replace(s.length() - 1, s.length(), "]");
        return s.toString();
    }

    @Override
    public boolean add(E e) {
        if (this.contains(e))
            return false;
        int index = Math.abs(e.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<>();
        buckets[index].add(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = Math.abs(o.hashCode()) % SIZE;
        if (buckets[index] == null)
            return false;
        for (E e : buckets[index]) {
            if (e.equals(o)) {
                buckets[index].remove(e);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int count = 0;
        for (Object o : c)
            if (this.contains(o))
                count++;
        return count == c.size();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        int start = this.size();
        for (E e : c)
            this.add(e);
        return (this.size() > start);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int n = this.size();
        for (LinkedList<E> bucket : buckets) {
            for (E e : bucket)
                if (!(c.contains(e)))
                    this.remove(e);
        }
        return n != this.size();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int n = this.size();
        for (Object o : c)
            this.remove(o);
        return n != this.size();
    }

    @Override
    public void clear() {
        for (LinkedList<E> bucket : buckets)
            if (bucket != null)
                bucket.clear();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof SimpleHashSet) {
            if ((this.size() == ((SimpleHashSet) obj).size())) {
                int count = 0;
                for (Object o : ((SimpleHashSet) obj))
                    if (this.contains(o))
                        count++;
                if (count == this.size())
                    return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {

        int result = 0;
        for (LinkedList<E> bucket : buckets)
            if (bucket != null)
                for (E e : bucket)
                    if (e != null)
                        result += e.hashCode();
        return result;
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
}
