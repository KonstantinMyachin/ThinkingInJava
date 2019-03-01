package ru.myachin.generics;

/**
 * 23. Измените пример {@link net.mindview.generics.FactoryConstraint}, чтобы метод
 * {@link net.mindview.generics.FactoryI#create()} получал аргумент.
 */
public class FactoryConstraint {

    public static void main(String[] args) {
        new Foo<>(new IntegerFactory(), 10);
        new Foo<>(new Widget.Factory(), 5);
    }
}

interface FactoryI<T> {

    T create(int i);
}

class Foo<T> {

    private T x;

    <F extends FactoryI<T>> Foo(F factory, int i) {
        x = factory.create(i);
    }
}

class IntegerFactory implements FactoryI<Integer> {

    @Override
    public Integer create(int i) {
        return i;
    }
}

class Widget {

    private Widget(int i) {
        System.out.println(String.format("Widget %d", i));
    }

    public static class Factory implements FactoryI<Widget> {

        @Override
        public Widget create(int i) {
            return new Widget(i);
        }
    }

}