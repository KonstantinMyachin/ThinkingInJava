package ru.myachin.initialization;

/**
 * 7. Создайте класс без конструктора. Создайте объект этого класса в методе {@link #main(String[])}, чтобы
 * удостовериться, что конструктор по умолчанию синтезируется автоматически.
 */
public class NonConstructor {

    public static void main(String[] args) {
        System.out.println(new NonConstructor());
    }
}