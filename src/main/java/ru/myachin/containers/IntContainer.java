package ru.myachin.containers;

import net.mindview.containers.Test;
import net.mindview.containers.TestParam;
import net.mindview.containers.Tester;

import java.util.ArrayList;
import java.util.List;

/**
 * 32. Повторите {@link StringContainer предыдущее упражнение} для контейнера <tt>int</tt> и сравните производительность
 * с {@link ArrayList}. Включите в сравнение процесс инкрементирования каждого элемента в контейнере.
 */
public class IntContainer {

    private int size;
    private int[] array;

    public IntContainer(int size) {
        array = new int[size];
    }

    public void add(int i) {
        if (size == array.length) {
            int[] extendedArray = new int[array.length + array.length / 2];
            System.arraycopy(array, 0, extendedArray, 0, array.length);
        }

        array[size++] = i;
    }

    public int get(int i) {
        return array[i];
    }

    public int size() {
        return size;
    }

    public void set(int position, int i) {
        array[position] = i;
    }
}

class TestIntContainer {

    static final int LOOPS = 10000;
    static List<Test<List<Integer>>> alTests = new ArrayList<>();
    static List<Test<IntContainer>> icTests = new ArrayList<>();

    static {
        alTests.add(new Test<List<Integer>>("add|set") {
            @Override
            protected int test(List<Integer> list, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    list.add(i);
                    list.set(i, list.get(i) + 1);
                }
                return LOOPS;
            }
        });
        icTests.add(new Test<IntContainer>("add|set") {
            @Override
            protected int test(IntContainer ic, TestParam tp) {
                for (int i = 0; i < LOOPS; i++) {
                    ic.add(i);
                    ic.set(i, ic.get(i) + 1);
                }
                return LOOPS;
            }
        });
    }

    public static void main(String[] args) {
        Tester.defaultParams = TestParam.array(LOOPS, 1);
        Tester.run(new ArrayList<>(LOOPS), alTests);
        Tester.run(new IntContainer(LOOPS), icTests);
    }
}
