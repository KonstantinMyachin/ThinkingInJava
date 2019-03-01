package ru.myachin.containers;

import net.mindview.containers.Test;
import net.mindview.containers.TestParam;
import net.mindview.containers.Tester;

import java.util.ArrayList;
import java.util.List;

/**
 * 31. Создайте контейнер, инкапсулирующий массив {@link String}. Контейнер должен поддерживать только добавление и
 * получение {@link String}, так что при использовании проблем с преобразованием типа не будет. Если размер внутреннего
 * массива недостаточен для следующего добавления, контейнер должен автоматически изменять его размер. В <tt>main()</tt>
 * сравните производительность контейнера c {@link ArrayList}
 */
public class StringContainer {

    private int size;
    private String[] array;

    public StringContainer(int size) {
        array = new String[size];
    }

    public void add(String s) {
        if (size == array.length) {
            String[] extendedArray = new String[array.length + array.length / 2];
            System.arraycopy(array, 0, extendedArray, 0, array.length);
        }

        array[size++] = s;
    }

    public String get(int i) {
        return array[i];
    }

    public int size() {
        return size;
    }
}

class TestStringContainer {
    static final int LOOPS = 10000;
    static List<Test<List<String>>> alTests = new ArrayList<>();
    static List<Test<StringContainer>> scTests = new ArrayList<>();

    static {
        alTests.add(new Test<List<String>>("add|get") {
            @Override
            protected int test(List<String> list, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    list.add(Integer.toString(i));
                    list.get(i);
                }
                return LOOPS;
            }
        });
        scTests.add(new Test<StringContainer>("add|get") {
            @Override
            protected int test(StringContainer sc, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    sc.add(Integer.toString(i));
                    sc.get(i);
                }
                return LOOPS;
            }
        });
    }

    public static void main(String[] args) {
        Tester.defaultParams = TestParam.array(LOOPS, 1);
        Tester.run(new ArrayList<>(LOOPS), alTests);
        Tester.run(new StringContainer(LOOPS), scTests);
    }
}
