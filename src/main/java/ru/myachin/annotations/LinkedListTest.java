package ru.myachin.annotations;

import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

import java.util.LinkedList;

/**
 * 6. Протестируйте контейнер {@link LinkedList} по образцу {@link net.mindview.annotations.HashSetTest}
 * <p>
 * 7. Измените предыдущее упражнение так, чтобы в нем использовалось наследование
 */
public class LinkedListTest extends LinkedList<String> {

    @Test
    void initialization() {
        assert isEmpty();
    }

    @Test
    void _contains() {
        add("one");
        assert contains("one");
    }

    @Test
    void _remove() {
        add("one");
        remove("one");
        assert isEmpty();
    }

    public static void main(String[] args) {
        OSExecute.command("java net.mindview.atunit.AtUnit LinkedListTest");
    }
}
