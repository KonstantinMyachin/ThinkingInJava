package ru.myachin.holding;

import ru.myachin.innerclasses.Selector;

import java.util.ArrayList;
import java.util.List;

/**
 * 3. Измените пример {@link ru.myachin.innerclasses.Sequence}, чтобы в контейнер можно было добавить произвольное
 * количество элементов.
 */
public class UnlimitedSequence {

    private List items = new ArrayList();

    public static void main(String[] args) {
        UnlimitedSequence sequence = new UnlimitedSequence();
        for (int i = 0; i < 5; i++) {
            sequence.add(i);
        }

        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
    }

    public void add(Object item) {
        items.add(item);
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    private class SequenceSelector implements Selector {
        private int i;

        @Override
        public boolean end() {
            return i == items.size();
        }

        @Override
        public Object current() {
            return items.get(i);
        }

        @Override
        public void next() {
            i++;
        }
    }
}
