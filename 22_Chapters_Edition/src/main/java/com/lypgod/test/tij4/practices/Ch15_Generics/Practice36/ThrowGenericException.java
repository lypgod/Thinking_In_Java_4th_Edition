package com.lypgod.test.tij4.practices.Ch15_Generics.Practice36;//: generics/ThrowGenericException.java

import java.util.*;

interface Processor<T, E extends Exception, E1 extends Exception> {
    void process(List<T> resultCollector) throws E, E1;
}

class ProcessRunner<T, E extends Exception, E1 extends Exception> extends ArrayList<Processor<T, E, E1>> {
    List<T> processAll() throws E, E1 {
        List<T> resultCollector = new ArrayList<>();
        for (Processor<T, E, E1> processor : this)
            processor.process(resultCollector);
        return resultCollector;
    }
}

class Failure1 extends Exception {
}

class Failure2 extends Exception {
}

class Processor1 implements Processor<String, Failure1, Failure2> {
    static int count = 3;

    public void process(List<String> resultCollector) throws Failure1, Failure2 {
        if (count-- > 1)
            resultCollector.add("Hep!");
        else
            resultCollector.add("Ho!");
        if (count < 0)
            throw new Failure1();
        if (count < -1)
            throw new Failure2();
    }
}

public class ThrowGenericException {
    public static void main(String[] args) {
        ProcessRunner<String,Failure1,Failure2> runner = new ProcessRunner<>();
        for(int i = 0; i < 3; i++)
            runner.add(new Processor1());
        try {
            System.out.println(runner.processAll());
        } catch(Failure1 | Failure2 e) {
            System.out.println(e);
        }
    }
} ///:~
