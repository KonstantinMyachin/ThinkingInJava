package ru.myachin.holding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 9. Измените пример {@link ru.myachin.innerclasses.Sequence} так, чтобы контейнер
 * {@link ru.myachin.innerclasses.Sequence} работал с {@link java.util.Iterator} вместо
 * {@link ru.myachin.innerclasses.Selector}.
 */
public class SequenceIterator {

    private List items = new ArrayList();

    public static void main(String[] args) {
        SequenceIterator sequence = new SequenceIterator();
        for (int i = 0; i < 5; i++) {
            sequence.add(i);
        }

        Iterator selector = sequence.selector();
        while (selector.hasNext()) {
            System.out.println(selector.next());
        }
    }

    public void add(Object item) {
        items.add(item);
    }

    public Iterator selector() {
        return new SequenceSelector();
    }

    private class SequenceSelector implements Iterator {
        private int i;

        @Override
        public boolean hasNext() {
            return i < items.size();
        }

        @Override
        public Object next() {
            return items.get(i++);
        }
    }
}
