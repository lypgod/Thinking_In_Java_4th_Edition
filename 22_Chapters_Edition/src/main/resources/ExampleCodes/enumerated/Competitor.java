//: enumerated/Competitor.java
// Switching one enum on another.
package ExampleCodes.enumerated;

public interface Competitor<T extends Competitor<T>> {
  Outcome compete(T competitor);
} ///:~
