package ru.myachin.holding;

import ru.myachin.polymorphism.Gerbil;
import ru.myachin.polymorphism.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 10. Измените {@link ru.myachin.polymorphism.Rodents упражнение 9 из главы 8}, чтобы объекты {@link Rodent} хранились
 * в контейнере {@link java.util.ArrayList}, а для перебора последовательности {@link Rodent} использовался
 * {@link Iterator итератор}.
 */
public class RodentIterator {

    public static void main(String[] args) {
        Member member = new Member();
        List<Rodent> list = new ArrayList<>(Arrays.asList(
                new Mouse(member), new Hamster(member), new Gerbil(member)
        ));

        Iterator<Rodent> iterator = list.iterator();
        while (iterator.hasNext()) {
            Rodent rodent = iterator.next();
            rodent.doSomething();
            rodent.reproduce();
        }
    }
}
