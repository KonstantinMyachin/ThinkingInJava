package ru.myachin.generics;

import net.mindview.typeinfo.pets.EgyptianMau;
import net.mindview.typeinfo.pets.Mouse;
import net.mindview.typeinfo.pets.Mutt;
import net.mindview.typeinfo.pets.Pet;
import net.mindview.util.New;
import net.mindview.util.TwoTuple;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 11. Протестируйте пример {@link New}, создайте собственные классы и убедитесь в том, что класс {@link New} правильно
 * работает с ним.
 * <p>
 * 12. Повторите предыдущее упражнение с явным указанием типа.
 */
public class NewTest {

    public static void main(String[] args) {
        final Map<Holder<Pet>, String> map = New.map();
        final Holder<Pet> petHolder = new Holder<>(new EgyptianMau(), new Mouse(), new Mutt());
        map.put(petHolder, "Some Pets");

        final Set<Pet> set = New.set();
        set.add(new Mouse());

        System.out.println(map.size());
        System.out.println(set.size());

        f(New.<TwoTuple<Integer, String>>list());
    }

    private static void f(List<TwoTuple<Integer, String>> list) {
        System.out.println(list);
    }
}
