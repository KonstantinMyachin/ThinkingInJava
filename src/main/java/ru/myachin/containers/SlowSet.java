package ru.myachin.containers;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 18. Взяв за образец {@link net.mindview.containers.SlowMap}, создайте аналогичную реализацию множества
 * <tt>SlowSet</tt>.
 */
public class SlowSet<E> extends AbstractSet<E> {

    private final List<E> elements = new ArrayList<>();

    @Override
    public boolean add(E e) {
        final boolean contains = elements.contains(e);
        if (!contains) {
            elements.add(e);
        }

        return !contains;
    }

    @Override
    public boolean remove(Object o) {
        return elements.remove(o);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public E next() {
                return elements.get(index++);
            }

            @Override
            public void remove() {
                elements.remove(--index);
            }
        };
    }

    @Override
    public int size() {
        return elements.size();
    }
}
