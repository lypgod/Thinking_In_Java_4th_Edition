package com.lypgod.test.tij4.practices.Ch17_Containers.Practice10;

import java.util.Iterator;
import java.util.LinkedList;

public class MySortedSet<E> extends LinkedList<E> {
    int compare(E e1, E e2) {
        return e1.hashCode() - e2.hashCode();
    }

    public boolean add(E e) {
        if (!this.contains(e)) {
            Iterator<E> it = this.iterator();
            int index = 0;
            while (it.hasNext()) {
                if (compare(it.next(), e) < 1)
                    index++;
            }
            add(index, e);
            return true;
        }
        return false;
    }
}
