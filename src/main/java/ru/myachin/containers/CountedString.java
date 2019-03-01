package ru.myachin.containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 26. Добавьте в <tt>CountedString</tt> поле <tt>char</tt>, которое также инициализируется в конструкторе. Измените
 * методы {@link #hashCode()} и {@link #equals(Object)}, чтобы в них включалось значение этого поля.
 * <p>
 * 27. Измените метод {@link #hashCode()} из <tt>CountedString.java</tt> - удалите использование комбинации с
 * <tt>id</tt>. Продемонстрируйте, что <tt>CountedString</tt> по-прежнему работает как ключ. В чем проблема такого
 * решения?
 */
public class CountedString {

    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;
    private char c;

    public CountedString(String s, char c) {
        this.s = s;
        this.c = c;
        created.add(s);
        for (String s2 : created) {
            if (s2.equals(s)) {
                id++;
            }
        }
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi", 'c');
            map.put(cs[i], i);
        }
        System.out.println(map);
        for (CountedString countedString : cs) {
            System.out.println("Looking up " + countedString);
            System.out.println(map.get(countedString));
        }
    }

    @Override
    public String toString() {
        return String.format("String: %s id: %d char: %c hashCode(): %d", s, id, c, hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountedString that = (CountedString) o;

        if (id != that.id) return false;
        if (c != that.c) return false;
        return s != null ? s.equals(that.s) : that.s == null;
    }

    @Override
    public int hashCode() {
        int result = s != null ? s.hashCode() : 0;
        result = 31 * result + (int) c;
        return result;
    }
}
