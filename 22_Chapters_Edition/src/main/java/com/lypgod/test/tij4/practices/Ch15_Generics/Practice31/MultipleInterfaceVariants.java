package com.lypgod.test.tij4.practices.Ch15_Generics.Practice31;//: generics/MultipleInterfaceVariants.java
// {CompileTimeError} (Won't compile)

interface Payable<T> {
}
//
//class Employee implements Payable<Employee> {
//}
//
//class Hourly extends Employee implements Payable<Hourly> {
//} ///:~

class Employee implements Payable {
}

class Hourly extends Employee implements Payable {
} ///:~

