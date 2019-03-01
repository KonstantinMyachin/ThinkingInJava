package ru.myachin.typeinfo;

import ru.myachin.typeinfo.pack.SomePackClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 25. Создайте класс, содержащий методы с разными уровнями доступа: закрытыми (private), защищеным (protected), с
 * доступом в пределах пакета. Напишите код для вызова этих методов из-за пределов пакета класса.
 */
public class HiddenMethodCalls {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        final SomePackClass somePackClass = new SomePackClass();
        for (Method method : somePackClass.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            method.invoke(somePackClass);
        }
    }
}
