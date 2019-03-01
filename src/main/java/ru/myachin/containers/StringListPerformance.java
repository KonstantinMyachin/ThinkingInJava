package ru.myachin.containers;

import net.mindview.containers.Test;
import net.mindview.containers.TestParam;
import net.mindview.containers.Tester;
import net.mindview.util.*;

import java.util.*;

/**
 * 29. Измените код {@link net.mindview.containers.ListPerformance} так, чтобы в {@link List} вместо {@link Integer}
 * хранились объекты {@link String}. Для создания тестовых значений используйте генератор из главы 16.
 * <p>
 * 30. Сравните производительность {@link Collections#sort(List)} для {@link ArrayList} и {@link LinkedList}
 */
public class StringListPerformance {

    static Generator<String> generator = new CountingGenerator.String();
    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<List<String>>> tests = new ArrayList<>();
    static List<Test<LinkedList<String>>> qTests = new ArrayList<>();

    static {
        tests.add(new Test<List<String>>("add") {
            @Override
            protected int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < listSize; j++) {
                        list.add(generator.next());
                    }
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<List<String>>("get") {
            @Override
            protected int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++) {
                    list.get(rand.nextInt(listSize));
                }
                return loops;
            }
        });
        tests.add(new Test<List<String>>("set") {
            @Override
            protected int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++) {
                    list.set(rand.nextInt(listSize), generator.next());
                }
                return loops;
            }
        });
        tests.add(new Test<List<String>>("iteradd") {
            @Override
            protected int test(List<String> list, TestParam tp) {
                final int LOOPS = 1000000;
                int half = list.size() / 2;
                ListIterator<String> it = list.listIterator(half);
                for (int i = 0; i < LOOPS; i++) {
                    it.add(generator.next());
                }
                return LOOPS;
            }
        });
        tests.add(new Test<List<String>>("insert") {
            @Override
            protected int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                for (int i = 0; i < loops; i++) {
                    list.add(5, generator.next());
                }
                return loops;
            }
        });
        tests.add(new Test<List<String>>("remove") {
            @Override
            protected int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(CollectionData.list(new CountingGenerator.String(), size));
                    while (list.size() > 5) {
                        list.remove(5); // Minimize random-access cost
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<List<String>>("sort") {
            @Override
            protected int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(CollectionData.list(new CountingGenerator.String(), size));
                    Collections.sort(list);
                }
                return loops * size;
            }
        });
        // Tests for queue behavior:
        qTests.add(new Test<LinkedList<String>>("addFirst") {
            @Override
            protected int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++) {
                        list.addFirst(generator.next());
                    }
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<String>>("addLast") {
            @Override
            protected int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++) {
                        list.addLast(generator.next());
                    }
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<String>>("rmFirst") {
            @Override
            protected int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(CollectionData.list(new CountingGenerator.String(), size));
                    while (list.size() > 0) {
                        list.removeFirst();
                    }
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<String>>("rmLast") {
            @Override
            protected int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(CollectionData.list(new CountingGenerator.String(), size));
                    while (list.size() > 0) {
                        list.removeLast();
                    }
                }
                return loops * size;
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        // Can only do these two tests on an array:
        Tester<List<String>> arrayTest =
                new Tester<List<String>>(null, tests.subList(1, 3)) {
                    // This will be called before each test. It
                    // produces a non-resizeable array-backed list:
                    @Override
                    protected List<String> initialize(int size) {
                        String[] ia = Generated.array(String.class, new CountingGenerator.String(), size);
                        return Arrays.asList(ia);
                    }
                };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
        Tester.defaultParams = TestParam.array(
                10, 5000, 100, 5000, 1000, 1000, 10000, 200);
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        StringListPerformance.ListTester.run(new ArrayList<>(), tests);
        StringListPerformance.ListTester.run(new LinkedList<>(), tests);
        StringListPerformance.ListTester.run(new Vector<>(), tests);
        Tester.fieldWidth = 12;
        Tester<LinkedList<String>> qTest = new Tester<>(
                        new LinkedList<>(), qTests);
        qTest.setHeadline("Queue tests");
        qTest.timedTest();
    }

    static class ListTester extends Tester<List<String>> {
        public ListTester(List<String> container,
                          List<Test<List<String>>> tests) {
            super(container, tests);
        }

        // Convenience method:
        public static void run(List<String> list,
                               List<Test<List<String>>> tests) {
            new StringListPerformance.ListTester(list, tests).timedTest();
        }
    }
}
