package com.lypgod.test.tij4.practices.Ch17_Containers.Practice8;

class LinkNode<E> {
    E e;
    LinkNode<E> next;

    LinkNode(E e, LinkNode<E> next) {
        this.e = e;
        this.next = next;
    }

    LinkNode(E e) {
        this(e, null);
    }

    @Override
    public String toString() {
        return e == null ? "null" : e.toString();
    }
}

class SList<E> {
    private LinkNode<E> headNode = new LinkNode<>(null);

    SListIterator<E> iterator() {
        return new SListIterator<>(headNode);
    }

    public String toString() {
        if (headNode.next == null)
            return "SList: []";
        SListIterator<E> it = this.iterator();
        StringBuilder s = new StringBuilder("SList: [");
        while (it.hasNext()) {
            s.append(it.next()).append(it.hasNext() ? ", " : "");
        }
        return s + "]";
    }
}

class SListIterator<E> {
    LinkNode<E> current;

    SListIterator(LinkNode<E> startNode) {
        current = startNode;
    }

    boolean hasNext() {
        return current.next != null;
    }

    LinkNode<E> next() {
        current = current.next;
        return current;
    }

    void insert(E e) {
        current.next = new LinkNode<>(e, current.next);
        current = current.next;
    }

    void remove() {
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

}

public class Practice8 {
    public static void main(String[] args) {
        SList<String> sl = new SList<>();
        System.out.println(sl);
        SListIterator<String> slIter = sl.iterator();
        System.out.println("inserting \"hi\"");
        slIter.insert("hi");
        System.out.println(sl);
        System.out.println("inserting \"there\"");
        slIter.insert("there");
        System.out.println(sl);
        System.out.println("inserting \"sweetie\"");
        slIter.insert("sweetie");
        System.out.println(sl);
        System.out.println("inserting \"pie\"");
        slIter.insert("pie");
        System.out.println(sl);
        SListIterator<String> slIter2 = sl.iterator();
        System.out.println("removing \"hi\"");
        slIter2.remove();
        System.out.println(sl);
        System.out.println("inserting \"hello\"");
        slIter2.insert("hello");
        System.out.println(sl);
        System.out.println("removing \"there\"");
        slIter2.remove();
        System.out.println(sl);
        System.out.println("removing \"sweetie\"");
        slIter2.remove();
        System.out.println(sl);
        System.out.println("removing \"pie\"");
        slIter2.remove();
        System.out.println(sl);
        System.out.println("removing \"hello\"");
        SListIterator slIter3 = sl.iterator();
        slIter3.remove();
        System.out.println(sl);
    }
}
