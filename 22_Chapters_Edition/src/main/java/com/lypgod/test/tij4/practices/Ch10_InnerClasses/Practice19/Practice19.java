package com.lypgod.test.tij4.practices.Ch10_InnerClasses.Practice19;

public class Practice19 {
    Practice19() { System.out.println("Practice19()"); }
    private class Practice19Inner {
        Practice19Inner() { System.out.println("Practice19Inner()"); }
        private class Practice19InnerInner {
            Practice19InnerInner() {
                System.out.println("Practice1919InnerInner()");
            }
        }
    }
    private static class Practice19Nested {
        Practice19Nested() { System.out.println("Practice19Nested()"); }
        private static class Practice19NestedNested {
            Practice19NestedNested() {
                System.out.println("Practice19NestedNested()");
            }
        }
    }
    public static void main(String[] args) {
        Practice19Nested practice19Nested = new Practice19Nested();
        Practice19Nested.Practice19NestedNested practice19NestedNested = new Practice19Nested.Practice19NestedNested();
        Practice19 practice19 = new Practice19();
        Practice19Inner practice19Inner = practice19.new Practice19Inner();
        Practice19Inner.Practice19InnerInner practice19InnerInner = practice19Inner.new Practice19InnerInner();
    }
}
/* compiler produces:
* Practice19$Practice19Inner$Practice19InnerInner.class
* Practice19$Practice19Inner.class
* Practice19$Practice19Nested$Practice19NestedNested.class
* Practice19$Practice19Nested.class
* Practice19.class
*/
