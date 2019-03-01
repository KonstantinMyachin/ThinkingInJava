package ru.myachin.containers;

import java.util.*;

/**
 * 10. Используя {@link LinkedList} в качестве базовой реализации, определите собственную реализацию {@link SortedSet}
 */
public class CustomSortedSet<E> implements SortedSet<E> {

    private LinkedList<E> list;

    public CustomSortedSet() {
        this.list = new LinkedList<>();
    }

    public CustomSortedSet(LinkedList<E> list) {
        this.list = list;
    }

    @Override
    public Comparator<? super E> comparator() {
        return null;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        return new CustomSortedSet<>(new LinkedList<>(list.subList(list.indexOf(fromElement), list.indexOf(toElement))));
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        return new CustomSortedSet<>(new LinkedList<>(list.subList(0, list.indexOf(toElement))));
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        return new CustomSortedSet<>(new LinkedList<>(list.subList(list.indexOf(fromElement), size())));
    }

    @Override
    public E first() {
        return list.getFirst();
    }

    @Override
    public E last() {
        return list.getLast();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(E e) {
        if (isEmpty()) {
            list.add(e);
        }

        @SuppressWarnings("unchecked")
        int index = Collections.binarySearch(((List<Comparable<E>>) list), e);
        if (index < 0) {
            index = -(index + 1);
            list.add(index, e);
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E e : c) {
            if (!contains(e)) {
                add(e);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
