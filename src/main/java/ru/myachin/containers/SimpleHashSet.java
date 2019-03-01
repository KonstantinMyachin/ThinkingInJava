package ru.myachin.containers;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 24. По образцу {@link net.mindview.containers.SimpleHashMap} создайте и протестируйте <tt>SimpleHashSet</tt>.
 */
public class SimpleHashSet<E> extends AbstractSet<E> {

    private static final int SIZE = 997;

    @SuppressWarnings("unchecked")
    private final LinkedList<E>[] buckets = new LinkedList[997];

    @Override
    public boolean add(E e) {
        int index = Math.abs(e.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        final LinkedList<E> bucket = buckets[index];
        if (bucket.contains(e)) {
            return false;
        }

        bucket.add(e);
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index;
            private int bucketNumber;
            private int indexInBucket;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public E next() {
                index++;
                while (bucketNumber < SIZE && buckets[bucketNumber] == null) {
                    bucketNumber++;
                }
                try {
                    return buckets[bucketNumber].get(indexInBucket++);
                } catch (IndexOutOfBoundsException e) {
                    bucketNumber++;
                    indexInBucket = 0;
                }

                return null;
            }

            @Override
            public void remove() {
                LinkedList<E> bucket = buckets[bucketNumber];
                bucket.remove(--indexInBucket);
                if (bucket.isEmpty()) {
                    buckets[bucketNumber] = null;
                }

                index--;
            }
        };
    }

    @Override
    public int size() {
        int result = 0;
        for (LinkedList<E> bucket : buckets) {
            if (bucket != null) {
                result += bucket.size();
            }
        }

        return result;
    }
}
