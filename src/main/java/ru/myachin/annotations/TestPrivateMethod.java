package ru.myachin.annotations;

import net.mindview.atunit.Test;
import net.mindview.atunit.TestProperty;
import net.mindview.util.OSExecute;

/**
 * 8. Создайте класс с закрытым методом и добавьте не-закрытый метод {@link TestProperty} так, как описано выше.
 * Вызовите этот метод в своем тестовом коде.
 */
public class TestPrivateMethod extends PrivateMethod {

    public static void main(String[] args) {
        OSExecute.command("java net.mindview.atunit.AtUnit TestPrivateMethod");
    }

    @Test
    void _hidden() {
        assert visible();
    }
}

class PrivateMethod {
    private boolean hidden() {
        return true;
    }

    @TestProperty
    boolean visible() {
        return hidden();
    }
}