package ru.myachin.generics;

import net.mindview.typeinfo.pets.Cat;
import net.mindview.typeinfo.pets.Mouse;
import net.mindview.typeinfo.pets.Pet;
import net.mindview.typeinfo.pets.Rodent;

/**
 * 28. Создайте обобщенный класс <tt>Generic<T></tt> с одним методом, получающим аргумент типа <tt>T</tt>. Создайте
 * второй обобщенный класс <tt>Generic2<T></tt> с одним методом, возвращающим аргумент тпиа <tt>T</tt>. Напишите
 * обобщенный метод с контравариантным аргументом первого обобщенного класса, который вызывает его метод.
 * Протестируйте на типах библиотеки {@link net.mindview.typeinfo.pets}.
 */
public class GenericGetAndSet {

    public static void main(String[] args) {
        Generic1<Rodent> g1 = new Generic1<>();
        doSomething(g1, new Mouse());
        Generic2<Pet> g2 = new Generic2<>();
        Pet pet = getGenericItem(g2);
        Generic2<Cat> g3 = new Generic2<>();
        Cat cat = getGenericItem(g3);
        pet = getGenericItem(g3);
    }

    private static <T> void doSomething(Generic1<? super T> obj, T item) {
        obj.setItem(item);
    }

    private static <T> T getGenericItem(Generic2<? extends T> obj) {
        return obj.getItem();
    }
}

class Generic1<T> {

    T item;

    void setItem(T item) {
        this.item = item;
    }
}

class Generic2<T> {

    T item;

    T getItem() {
        return item;
    }
}