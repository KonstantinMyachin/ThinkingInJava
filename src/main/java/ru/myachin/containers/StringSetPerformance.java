package ru.myachin.containers;

import net.mindview.containers.Test;
import net.mindview.containers.TestParam;
import net.mindview.containers.Tester;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generator;

import java.util.*;

/**
 * 34. Измените код {@link net.mindview.containers.SetPerformance} так, чтобы в {@link Set} вместо {@link Integer}
 * хранились объекты {@link String}. Для создания тестовых значений используйте генератор из главы 16.
 */
public class StringSetPerformance {
    static List<Test<Set<String>>> tests = new ArrayList<>();
    private static Generator<String> generator = new CountingGenerator.String();

    static {
        tests.add(new Test<Set<String>>("add") {
            @Override
            protected int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    set.clear();
                    for (int j = 0; j < size; j++) {
                        set.add(generator.next());
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<Set<String>>("contains") {
            @Override
            protected int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++)
                    for (int j = 0; j < span; j++) {
                        set.contains(generator.next());
                    }
                return loops * span;
            }
        });
        tests.add(new Test<Set<String>>("iterate") {
            @Override
            protected int test(Set<String> set, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                return loops * set.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        Tester.fieldWidth = 10;
        Tester.run(new TreeSet<>(), tests);
        Tester.run(new HashSet<>(), tests);
        Tester.run(new LinkedHashSet<>(), tests);
    }
}
