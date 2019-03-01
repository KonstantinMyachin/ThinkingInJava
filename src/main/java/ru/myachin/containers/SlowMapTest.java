package ru.myachin.containers;

import net.mindview.containers.MapEntry;
import net.mindview.containers.Maps;
import net.mindview.containers.SlowMap;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * 16. Примените тесты из {@link Maps} к {@link SlowMap} и проверьте, работает ли класс. Исправьте в {@link SlowMap}
 * все, что работает некорректно.
 * <p>
 * 17. Реализуйте оставшуюся часть интерфейса {@link java.util.Map} для {@link SlowMap}
 */
public class SlowMapTest {

    public static void main(String[] args) {
        Maps.test(new CorrectedSlowMap<>());
    }
}

class CorrectedSlowMap<K, V> extends SlowMap<K, V> {

    private AbstractSet<Entry<K, V>> entries = new AbstractSet<Entry<K, V>>() {

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new Iterator<Entry<K, V>>() {
                private int index;

                @Override
                public boolean hasNext() {
                    return index < keys.size();
                }

                @Override
                public Entry<K, V> next() {
                    return new MapEntry<>(keys.get(index), values.get(index++));
                }

                @Override
                public void remove() {
                    keys.remove(--index);
                    values.remove(index);
                }
            };
        }

        @Override
        public int size() {
            return keys.size();
        }
    };

    @Override
    public Set<Entry<K, V>> entrySet() {
        return entries;
    }

    @Override
    public Collection<V> values() {
        return values;
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }
}