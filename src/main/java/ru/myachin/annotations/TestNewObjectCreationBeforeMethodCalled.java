package ru.myachin.annotations;

import net.mindview.atunit.Test;
import net.mindview.util.OSExecute;

import java.util.HashSet;

/**
 * 4. Убедитесь в том, что перед каждым тестом создается новый объект <tt>testObject</tt>
 * <p>
 * 5. Измените предыдущее упражнение, чтобы в нем использовалось наследование
 */
public class TestNewObjectCreationBeforeMethodCalled extends HashSet<String>{

    public static void main(String[] args) {
        OSExecute.command("java net.mindview.atunit.AtUnit TestNewObjectCreationBeforeMethodCalled");
    }

    @Test
    void _t1() {
        assert isEmpty();
        add("someString");
    }

    @Test
    void _t2() {
        assert isEmpty();
        add("someString");
    }
}

