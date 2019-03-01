package ru.myachin.generics;

import net.mindview.util.FiveTuple;

/**
 * 3. Создайте и протестируйте обобщенный тип SixTuple для шести элементов
 */
public class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E> {

    private F f;

    public SixTuple(A a, B b, C c, D d, E e, F f) {
        super(a, b, c, d, e);
        this.f = f;
    }

    @Override
    public String toString() {
        return super.toString().replaceFirst("\\)", String.format(", %s)", f));
    }
}
