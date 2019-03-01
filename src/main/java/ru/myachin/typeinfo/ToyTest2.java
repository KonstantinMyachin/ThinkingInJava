package ru.myachin.typeinfo;

import net.mindview.typeinfo.toys.ToyTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 1. В примере {@link ToyTest} закомментируйте конструктор <tt>Toy</tt> по умолчанию. Объсните, что при этом
 * происходит.
 * <p>
 * 2. Встройте новый интерфейс в {@link ToyTest}. Убедитесь в том, что он обнаруживается, а информация о нем
 * выводится программой.
 * <p>
 * 19. В программе {@link ToyTest} используйте отражение для создание объекта {@link net.mindview.typeinfo.toys.Toy} с
 * аргументом.
 */
public class ToyTest2 {

    public static void main(String[] args) {
        ToyTest.main(args);
        try {
            final Class<?> aClass = Class.forName("net.mindview.typeinfo.toys.Toy");
            final Constructor<?> constructor = aClass.getDeclaredConstructor(int.class);
            constructor.setAccessible(true);
            final Object o = constructor.newInstance(10);
            System.out.println(o.getClass().getSimpleName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No such class Toy: " + e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("No such constructor for Toy: " + e);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
