package ru.myachin.generics;

/**
 * 2. Создайте класс для хранения трех объектов одного типа, с методами соохранения и выборки этих объектов и
 * конструктором для инициализации всех трех объектов.
 */
public class Holder<T> {

    private T first;
    private T second;
    private T third;

    public Holder(T first, T second, T third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    public T getThird() {
        return third;
    }

    public void setThird(T third) {
        this.third = third;
    }
}
