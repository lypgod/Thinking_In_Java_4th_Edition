package com.lypgod.test.tij4.practices.Ch5_InitializationAndCleanup.Practice15;

class InstanceClause {
    String s;
    InstanceClause() {
        System.out.println("Constructor");
    }

    {
        s = "String";
        System.out.println("Instance Clause");
    }

    static {
        System.out.println("Static Block");
    }

    void print() {
        System.out.println(s);
    }
}

public class InstanceClauseTest {
    public static void main(String[] args) {
        InstanceClause instanceClause = new InstanceClause();
        instanceClause.print();
    }
}
