package ru.myachin.innerclasses;

/**
 * 4. Добавьте в класс {@link SequenceSelector} метод для получения ссылки на внешний класс {@link Sequence}
 * <p>
 * 22. Реализуйте reverseSelector в {@link Sequence}
 */
public class Sequence {

    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
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

        public Sequence getSequence() {
            return Sequence.this;
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

        public Sequence getSequence() {
            return Sequence.this;
        }
    }
}