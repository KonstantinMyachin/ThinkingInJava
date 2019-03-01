package ru.myachin.generics;

/**
 * 4. "Обобщите" пример {@link ru.myachin.innerclasses.Sequence}
 */
interface Selector<E> {

    boolean end();

    E current();

    void next();

}

public class GenericSequence<E> {

    private E[] items;
    private int next = 0;

    @SuppressWarnings("unchecked")
    public GenericSequence(int size) {
        items = (E[]) new Object[size];
    }

    public static void main(String[] args) {
        int n = 5;
        GenericSequence<String> sequence = new GenericSequence<>(n);
        for (int i = 0; i < n; i++) {
            sequence.add(String.valueOf(i));
        }

        final Selector<String> selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }

    public void add(E x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    public Selector<E> selector() {
        return new SequenceSelector();
    }

    public Selector<E> reverseSelector() {
        return new ReverseSequenceSelector();
    }

    private class SequenceSelector implements Selector<E> {

        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public E current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }

        public GenericSequence getSequence() {
            return GenericSequence.this;
        }
    }

    private class ReverseSequenceSelector implements Selector<E> {

        private int i = items.length - 1;

        @Override
        public boolean end() {
            return i < 0;
        }

        @Override
        public E current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i >= 0) {
                i--;
            }
        }

        public GenericSequence getSequence() {
            return GenericSequence.this;
        }
    }
}