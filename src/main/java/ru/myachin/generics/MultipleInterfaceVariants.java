package ru.myachin.generics;

/**
 * 31. Удалите все обобщения из <tt>MultipleInterfaceVariants</tt> и измените код, чтобы пример компилировался.
 */
public class MultipleInterfaceVariants {

    public static void main(String[] args) {
        new Hourly();
        new Employee();
    }
}

interface Payable {

}

class Employee implements Payable {

}

class Hourly extends Employee implements Payable {

}
