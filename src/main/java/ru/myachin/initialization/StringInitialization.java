package ru.myachin.initialization;

/**
 * 2. Создайте класс с полем {@link String}, инициализируемым в точке определения, и другим полем, инициализируемым
 * конструктором. Чем отличаются эти два подхода?
 */
public class StringInitialization {

    String s1 = "Initialize in the definition";
    private String s2;

    public StringInitialization(String s2) {
        this.s2 = s2;
    }

    public static void main(String[] args) {
        new StringInitialization("Initialize in constructor");
    }
}