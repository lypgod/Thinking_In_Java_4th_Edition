//: innerclasses/controller/Controller.java
// The reusable framework for control systems.
package com.lypgod.test.tij4.practices.Ch11_HoldingYourObjects.Practice13.controller;

import java.util.*;

public class Controller {
    // A class from java.util to hold Event objects:
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        LinkedList<Event> eventListCopy = new LinkedList<>(eventList);
        ListIterator<Event> it = eventListCopy.listIterator();
        while(it.hasNext()) {
            it.next().action();
            it.previous();
            System.out.println(it.next());
        }
    }
} ///:~
