package ru.myachin.exceptions;

import ru.myachin.innerclasses.Selector;

/**
 * 12. Измените пример {@link ru.myachin.innerclasses.Sequence} так, чтобы при попытке размещения слишком большого
 * количества элементов программа выдавала соответствующее исключение.
 */
public class SequenceException {

    private Object[] items;
    private int next = 0;

    public SequenceException(int size) {
        items = new Object[size];
    }

    public static void main(String[] args) {
        SequenceException sequence = new SequenceException(5);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.valueOf(i));
        }
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        } else {
            throw new SequenceFullException();
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public Selector reverseSelector() {
        return new ReverseSequenceSelector();
    }

    private class SequenceSelector implements Selector {

        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }

        public SequenceException getSequence() {
            return SequenceException.this;
        }
    }

    private class ReverseSequenceSelector implements Selector {

        private int i = items.length - 1;

        @Override
        public boolean end() {
            return i < 0;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i >= 0) {
                i--;
            }
        }

        public SequenceException getSequence() {
            return SequenceException.this;
        }
    }
}

class SequenceFullException extends RuntimeException {

}