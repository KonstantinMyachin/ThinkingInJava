package ru.myachin.containers;

import net.mindview.containers.MapEntry;
import net.mindview.containers.SimpleHashMap;
import net.mindview.util.Countries;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

/**
 * 20. Измените реализацию {@link SimpleHashMap} так, чтобы она сообщала о коллизиях. Чтобы протестировать результат,
 * добавьте один рабор данных дважды, чтобы спровоцировать коллизию.
 * <p>
 * 21. Измените реализацию {@link SimpleHashMap} так, чтобы она сообщала количество необходимых "проб" при возникновении
 * коллизий. Иначе говоря, сколько вызовов <tt>next()</tt> должно выполняться интератором, обходящим списки
 * {@link LinkedList} в поисках совпадений.
 * <p>
 * 22. Реализуйте методы {@link Map#clear()} и {@link Map#remove(Object)} для {@link SimpleHashMap}
 * <p>
 * 23. Реализуйте остаток интерфейса {@link Map} для {@link SimpleHashMap}
 */
public class SimpleHashMapCollisions {

    public static void main(String[] args) {
        final Map<String, String> capitals = Countries.capitals(10);
        final CorrectedSimpleHashMap<Object, Object> hashMap = new CorrectedSimpleHashMap<>();
        hashMap.putAll(capitals);
        hashMap.putAll(capitals);
        System.out.println(hashMap.size());
        final String capital = capitals.keySet().iterator().next();
        System.out.println(hashMap.containsKey(capital));
        hashMap.remove(capital);
        System.out.println(hashMap.containsKey(capital));
        System.out.println(hashMap.size());
        hashMap.clear();
        System.out.println(hashMap.isEmpty());
    }
}

class CorrectedSimpleHashMap<K, V> extends SimpleHashMap<K, V> {

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        MapEntry<K, V> pair = new MapEntry<>(key, value);

        boolean hasCollision = false;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        } else {
            hasCollision = true;
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();

        int collisionCount = 0;
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (hasCollision) {
                collisionCount++;
            }
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
        }

        if (hasCollision) {
            final String collisionMsg =
                    String.format("Collision in adding %s with %d elements: %s", pair, collisionCount, buckets[index]);
            System.out.println(collisionMsg);
        }

        return oldValue;
    }

    @Override
    public void clear() {
        buckets = new LinkedList[SIZE];
    }

    @Override
    public V remove(Object key) {
        if (containsKey(key)) {
            int index = Math.abs(key.hashCode()) % SIZE;
            final LinkedList<MapEntry<K, V>> list = buckets[index];
            for (MapEntry<K, V> entry : list) {
                if (entry.getKey().equals(key)) {
                    list.remove(entry);
                    return entry.getValue();
                }
            }
        }

        throw null;
    }
}