//: annotations/ExtractInterface.java
// APT-based annotation processing.
package com.lypgod.test.tij4.practices.Ch20_Annotations.Practice2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {
    String value();
} ///:~
