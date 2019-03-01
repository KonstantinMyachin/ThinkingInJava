package ru.myachin.generics;

/**
 * 34. Создайте самоограничиваемый обобщенный тип с абстрактным методом, который получает обобщенный параметр-тип и
 * возвращает обобщенный параметр-тип. В неабстрактном методе класса вызовите абстрактный метод и верните его результат.
 * Используйте наследование от самоограничваемого типа и протестируйте полученный класс.
 */
public abstract class SelfBounded<T extends SelfBounded<T>> {

    abstract T getGenericObject(T obj);

    public static void main(String[] args) {
        System.out.println(new SubClass().nonAbstractMethod());
    }

    T nonAbstractMethod() {
        return getGenericObject(null);
    }
}

class SubClass extends SelfBounded<SubClass> {

    @Override
    SubClass getGenericObject(SubClass obj) {
        return obj;
    }
}