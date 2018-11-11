package com.lypgod.test.tij4.practices.Ch17_Containers.Practice28;

import java.util.*;

class TwoTuple<A, B> implements Comparable {
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof TwoTuple))
            throw new ClassCastException();
        TwoTuple t = (TwoTuple) o;
        return (this.hashCode() - t.hashCode() < 0) ? -1 : ((this.hashCode() - t.hashCode() > 0 ? 1 : 0));
    }

    @Override
    public int hashCode() {
        return (17 * 37 + first.hashCode()) * 37 + second.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TwoTuple && ((TwoTuple) obj).first.equals(first) && ((TwoTuple) obj).second.equals(second);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class ThreeTuple<A, B, C> extends TwoTuple<A, B> implements Comparable {
    public final C third;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        third = c;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 37 + third.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ThreeTuple && ((ThreeTuple) o).first.equals(first) && ((ThreeTuple) o).second.equals(second) && ((ThreeTuple) o).third.equals(third);
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof ThreeTuple))
            throw new ClassCastException();
        ThreeTuple t = (ThreeTuple) o;
        return (this.hashCode() - t.hashCode() < 0) ? -1 : ((this.hashCode() - t.hashCode() > 0 ? 1 : 0));
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }
}

class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> implements Comparable {
    public final D fourth;

    public FourTuple(A a, B b, C c, D d) {
        super(a, b, c);
        fourth = d;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 37 + fourth.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof FourTuple && ((FourTuple) o).first.equals(first) && ((FourTuple) o).second.equals(second) && ((FourTuple) o).third.equals(third) && ((FourTuple) o).fourth.equals(fourth);
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof FourTuple))
            throw new ClassCastException();
        FourTuple t = (FourTuple) o;
        return (this.hashCode() - t.hashCode() < 0) ? -1 : ((this.hashCode() - t.hashCode() > 0 ? 1 : 0));
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ")";
    }
}

class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> implements Comparable {
    public final E fifth;

    public FiveTuple(A a, B b, C c, D d, E e) {
        super(a, b, c, d);
        fifth = e;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 37 + fifth.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof FiveTuple && ((FiveTuple) o).first.equals(first) && ((FiveTuple) o).second.equals(second) && ((FiveTuple) o).third.equals(third) && ((FiveTuple) o).fourth.equals(fourth) && ((FiveTuple) o).fifth.equals(fifth);
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof FiveTuple))
            throw new ClassCastException();
        FiveTuple t = (FiveTuple) o;
        return (this.hashCode() - t.hashCode() < 0) ? -1 : ((this.hashCode() - t.hashCode() > 0 ? 1 : 0));
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ", " + fifth + ")";
    }
}

class Tuple {
    public <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<>(a, b);
    }

    public <A, B, C> ThreeTuple<A, B, C> tuple(A a, B b, C c) {
        return new ThreeTuple<>(a, b, c);
    }

    public <A, B, C, D> FourTuple<A, B, C, D> tuple(A a, B b, C c, D d) {
        return new FourTuple<>(a, b, c, d);
    }

    public <A, B, C, D, E> FiveTuple<A, B, C, D, E> tuple(A a, B b, C c, D d, E e) {
        return new FiveTuple<>(a, b, c, d, e);
    }
}

public class GeneralTuples {
    public static void main(String[] args) {
        Tuple t = new Tuple();
        FiveTuple t1b = t.tuple(1, 1, 1, 1, 1);
        FiveTuple t2b = t.tuple(1, 1, 1, 2, 1);
        FiveTuple t3b = t.tuple(1, 1, 1, 1, 1);
        FiveTuple t4b = t.tuple(1, 1, 1, 1, 0);
        System.out.println(t1b.compareTo(t1b));
        System.out.println(t1b.compareTo(t2b));
        System.out.println(t1b.compareTo(t3b));
        System.out.println(t1b.compareTo(t4b));
        List<FiveTuple> list = new ArrayList<>(Arrays.asList(t1b, t2b, t3b, t4b));
        Set<FiveTuple> s = new TreeSet<>();
        s.addAll(list);
        System.out.println(s);
    }
}
