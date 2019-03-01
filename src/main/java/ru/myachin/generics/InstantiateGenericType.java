package ru.myachin.generics;

import java.lang.reflect.InvocationTargetException;

/**
 * 22. Используя метку типа в сочетании с отражением, создайте метод, использующий версию {@link Class#newInstance()
 * с аргументами для создания объекта класса, конструктор которого получает аргументы.
 */
public class InstantiateGenericType<T> {

    final Class<T> kind;

    public InstantiateGenericType(Class<T> kind) {
        this.kind = kind;
    }

    public T create(boolean value) {
        try {
            return kind.getConstructor(boolean.class).newInstance(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
