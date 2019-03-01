package ru.myachin.innerclasses;

/**
 * 5. Создайте класс с внутренним классом. В отдельном классе создайте экземпляр внутреннего класа.
 */
public class InstanceOfInner {

    public static void main(String[] args) {
        Outer.Inner inner = new Outer("Java").new Inner();
        System.out.println(inner);
    }
}