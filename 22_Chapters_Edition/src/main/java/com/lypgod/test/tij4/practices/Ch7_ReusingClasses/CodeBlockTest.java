package com.lypgod.test.tij4.practices.Ch7_ReusingClasses;

/**
 * Created by liuyp on 16-10-8.
 */
class Code {
    {
        System.out.println("Code的构造块");
    }

    static {
        System.out.println("Code的静态代码块");
    }

    public Code() {
        System.out.println("Code的构造方法");
    }
}

public class CodeBlockTest {
    {
        System.out.println("CodeBlock03的构造块");
    }

    static {
        System.out.println("CodeBlock03的静态代码块");
    }

    public CodeBlockTest() {
        System.out.println("CodeBlock03的构造方法");
    }

    public static void main(String[] args) {
        System.out.println("CodeBlock03的主方法");
        new Code();
        new Code();
        new CodeBlockTest();
        new CodeBlockTest();
    }
}
