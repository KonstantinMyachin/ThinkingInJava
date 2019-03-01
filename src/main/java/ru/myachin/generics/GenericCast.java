package ru.myachin.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 32. Убедитесь в том, что <tt>FixedSizeStack</tt> в <tt>GenericCast.java</tt> генерирует предупреждения при попытке
 * выхода за границы. Означает ли это, что код проверки границ не обязателен?
 * <p>
 * 33. Исправьте ошибку в <tt>GenericCast.java</tt> с использованием {@link ArrayList}
 */
public class GenericCast {

    private static final int SIZE = 10;

    public static void main(String[] args) {
        //final FixedSizeStack<String> strings = new FixedSizeStack<>(SIZE);
        final FixedSizeStack2<String> strings = new FixedSizeStack2<>(SIZE);

        for (String s : "A B C D E F G H I J".split(" ")) {
            strings.push(s);
        }

        try {
            strings.push("K");
        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < SIZE; i++) {
            System.out.println(strings.pop());
        }
    }
}

class FixedSizeStack<T> {

    private int index = 0;
    private Object[] storage;

    public FixedSizeStack(int size) {
        storage = new Object[size];
    }

    public void push(T item) {
        storage[index++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        return (T) storage[--index];
    }
}

class FixedSizeStack2<T> {

    private final int size;
    private final List<T> storage;
    private int index;

    FixedSizeStack2(int size) {
        storage = new ArrayList<>(size);
        this.size = size;
    }

    void push(T item) {
        if (index < size) {
            index++;
            storage.add(item);
        } else {
            throw new RuntimeException(String.format("Cannot store object %s. Stack is full", item));
        }
    }

    T pop() {
        if (index > 0) {
            return storage.get(--index);
        }

        throw new RuntimeException("Cannot get object from stack. Stack is empty");
    }
}