//: net/mindview/util/Generator.java
// A generic interface.
package com.lypgod.test.tij4.practices.Ch16_Arrays.Practice16;

interface Generator<T> {
    T next();
} ///:~

interface SkipGenerator<T> extends Generator<T> {
    T next();
    T next(int n);
}