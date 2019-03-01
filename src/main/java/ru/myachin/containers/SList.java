package ru.myachin.containers;

import java.util.NoSuchElementException;

/**
 * 8. Создайте обобщенный класс односвязного списка с именем <tt>SList</tt>, который для простоты не реализует
 * интерфейс {@link java.util.List}. Каждый объекта узла <tt>Link</tt> должен содержать ссылку на слуедующий элемент
 * списка но не на предыдущий (в отличие от {@link java.util.LinkedList двусвязного списка}, который поддерживает
 * ссылки в обоих направлениях). Создайте собственную реализацию <tt>SListIterator</tt>, которая (опять же для простоты)
 * не реализует {@link java.util.ListIterator}. Кроме {@link #toString()}, класс <tt>SList</tt> должен содержать только
 * метод <tt>iterator()</tt>, который создает <tt>SListIterator</tt>. Вставка и удаление элементов <tt>SList</tt>
 * должны выполняться только через <tt>SListIterator</tt>. Напишите код для демонстрации <tt>SList</tt>.
 */
public class SList<E> {

    private Link<E> first;
    private long size;

    public static void main(String[] args) {
        SList<String> list = new SList<>();
        final SListIterator iterator = list.iterator();
        iterator.add("One");
        iterator.add("Two");
        iterator.add("Three");
        System.out.println(list);
        iterator.remove();
        System.out.println(list);
    }

    public SListIterator iterator() {
        return new SListIteratorImpl();
    }

    @Override
    public String toString() {
        final SListIterator iterator = iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            sb.append(", ");
        }

        if (sb.length() == 0) {
            return "[]";
        } else {
            sb.insert(0, "[");
            sb.replace(sb.length() - 2, sb.length(), "");
            sb.append("]");
        }

        return sb.toString();
    }

    private static class Link<E> {
        private E value;
        private Link<E> next;

        Link(E value) {
            this.value = value;
        }

    }

    private class SListIteratorImpl implements SListIterator<E> {
        private long index;
        private Link<E> current;
        private Link<E> previous;

        private SListIteratorImpl() {
            current = first;
        }

        @Override
        public void add(E value) {
            if (first == null) {
                first = new Link<>(value);
                size++;
            } else {
                Link<E> next = first.next;
                Link<E> target = first;
                while (next != null) {
                    target = next;
                    next = next.next;
                }

                target.next = new Link<>(value);
                size++;
            }
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            previous = current;
            current = current.next;
            index++;

            return previous.value;
        }

        @Override
        public void remove() {
            Link<E> next = first;
            while (next != null) {
                if (next.next == previous) {
                    next.next = null;
                    size--;
                    break;
                }

                next = next.next;
            }
        }
    }
}

interface SListIterator<E> {

    boolean hasNext();

    E next();

    void remove();

    void add(E element);
}