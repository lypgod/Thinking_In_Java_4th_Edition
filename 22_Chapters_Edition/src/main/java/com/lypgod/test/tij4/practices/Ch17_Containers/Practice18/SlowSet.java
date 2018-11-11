package com.lypgod.test.tij4.practices.Ch17_Containers.Practice18;

import java.util.*;

@SuppressWarnings({"SuspiciousToArrayCall", "SuspiciousMethodCalls"})
public class SlowSet<E> implements Set<E> {
    private List<E> elements = new ArrayList<>();

    public static void main(String[] args) {
        SlowSet<String> ss = new SlowSet<>();
        ss.add("hi");
        System.out.println(ss);
        ss.add("there");
        System.out.println(ss);
        List<String> list = Arrays.asList("you", "cutie", "pie");
        ss.addAll(list);
        System.out.println(ss);
        System.out.println("ss.size() = " + ss.size());
        System.out.println("ss.contains(\"you\"): " + ss.contains("you"));
        System.out.println("ss.contains(\"me\"): " + ss.contains("me"));
        System.out.println("ss.containsAll(list): " + ss.containsAll(list));
        SlowSet<String> ss2 = new SlowSet<>();
        System.out.println("ss2 = " + ss2);
        System.out.println("ss.containsAll(ss2): " + ss.containsAll(ss2));
        System.out.println("ss2.containAll(ss): " + ss2.containsAll(ss));
        ss2.add("you");
        ss2.add("cutie");
        ss.removeAll(ss2);
        System.out.println("ss = " + ss);
        System.out.println("ss.hashCode() = " + ss.hashCode());
        List<String> list2 = Arrays.asList("hi", "there", "pie");
        ss2.remove("you");
        System.out.println(ss2);
        System.out.println("ss2.isEmpty(): " + ss2.isEmpty());
        ss2.clear();
        System.out.println("ss2.isEmpty(): " + ss2.isEmpty());
        ss2.addAll(list2);
        System.out.println("ss2 = " + ss2);
        System.out.println("ss.equals(ss2): " + ss.equals(ss2));
        String[] sa = new String[3];
        System.out.println("ss.toArray(sa): " + Arrays.toString(ss.toArray(sa)));
        for (String aSa : sa)
            System.out.print(aSa + " ");
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean isEmpty() {
        return (elements.size() == 0);
    }

    @Override
    public boolean contains(Object o) {
        return elements.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }

    @Override
    public Object[] toArray() {
        return elements.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return elements.toArray(a);
    }

    @Override
    public boolean add(E e) {
        if (elements.contains(e))
            return false;
        elements.add(e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return (elements.remove(o));
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int count = 0;
        for (Object o : c)
            if (elements.contains(o))
                count++;
        return count == c.size();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return (elements.addAll(c));
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int n = elements.size();
        for (int i = 0; i < elements.size(); i++) {
            E e = elements.get(i);
            if (!(c.contains(e)))
                elements.remove(e);
        }
        return n != elements.size();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int n = elements.size();
        for (Object o : c)
            elements.remove(o);
        return n != elements.size();
    }

    @Override
    public void clear() {
        elements.clear();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SlowSet) {
            if ((elements.size() == ((SlowSet) obj).size())) {
                int count = 0;
                for (int i = 0; i < elements.size(); i++)
                    if (elements.get(i).equals(((SlowSet) obj).elements.get(i)))
                        count++;
                if (count == elements.size())
                    return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {

        int result = 0;
        for (E element : elements)
            result += element.hashCode();
        return result;
    }

    @Override
    public String toString() {

        if (elements.size() == 0)
            return "[]";
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < elements.size() - 1; i++)
            s.append(String.valueOf(elements.get(i))).append(", ");
        s.append(String.valueOf(elements.get(elements.size() - 1)));
        s.append("]");
        return s.toString();
    }
}
