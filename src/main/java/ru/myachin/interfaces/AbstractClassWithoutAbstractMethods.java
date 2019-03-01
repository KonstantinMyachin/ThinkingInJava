package ru.myachin.interfaces;

/**
 * 2. Создайте класс и объявите его как <b>abstract</b>, не включая в него ни одного абстрактного метода. Затем
 * убедитесь, что вы не можете создавать экземпляры этого класса.
 */
public abstract class AbstractClassWithoutAbstractMethods {

    public static void main(String[] args) {
//        new AbstractClassWithoutAbstractMethods(); compile error
    }

    void nonAbstractMethod() {
        System.out.println("NonAbstractMethod()");
    }
}