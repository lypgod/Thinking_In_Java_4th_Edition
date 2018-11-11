package com.lypgod.test.tij4.practices.Ch9_Interfaces.Practice11;

/**
 * Created by liuyp on 16-10-10.
 */
class StringProcessor implements Processor {

    @Override
    public String name() {
        return "StringProcessor";
    }

    @Override
    public Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}
public class Practice11 {
    public static void main(String[] args) {
        Apply.process(new StringProcessor(), "abcde");
    }
}
