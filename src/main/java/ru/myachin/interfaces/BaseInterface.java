package ru.myachin.interfaces;

/**
 * 13. Создайте интерфейс и определите два новых интерфейса, производных от него. Выполните множественное
 * наследование третьего интерфейса от первых двух.
 */
public interface BaseInterface {

    void abstractMethod();
}

interface AnotherInterface extends BaseInterface {

    @Override
    void abstractMethod();
}

interface ThirdInterface extends BaseInterface {

    @Override
    void abstractMethod();
}

interface CombinedInterface extends AnotherInterface, ThirdInterface {

    @Override
    void abstractMethod();
}