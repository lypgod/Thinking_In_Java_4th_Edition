package com.lypgod.test.tij4.practices.Ch13_Strings.Practice4;//: strings/Receipt.java

import java.util.*;

public class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);
    private int itemLength = 20;
    private int qtyLength = 10;
    private int priceLength = 15;
    private String titleLine = "%-" + itemLength + "s %" + qtyLength + "s %" + priceLength + "s\n";
    private String contentlLine = "%-" + itemLength + "." + itemLength + "s %" + qtyLength + "d %" + priceLength + ".2f\n";
    private String totleLine = "%-" + itemLength + "s %" + qtyLength + "s %" + priceLength + ".2f\n";

    public void printTitle() {
        f.format(titleLine, "Item", "Qty", "Price");
        f.format(titleLine, "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format(contentlLine, name, qty, price);
        total += price;
    }

    public void printTotal() {
        f.format(totleLine, "Tax", "", total * 0.06);
        f.format(titleLine, "", "", "-----");
        f.format(totleLine, "Total", "",
                total * 1.06);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
} /* Output:
Item              Qty      Price
----              ---      -----
Jack's Magic Be     4       4.25
Princess Peas       3       5.10
Three Bears Por     1      14.29
Tax                         1.42
                           -----
Total                      25.06
*///:~
