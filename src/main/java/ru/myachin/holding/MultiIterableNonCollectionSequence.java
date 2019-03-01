package ru.myachin.holding;

import net.mindview.typeinfo.pets.Pet;

/**
 * 32. По образцу <b>MultiIterableClass</b> добавьте методы <b>reversed()</b> и <b>randomized()</b> в
 * {@link NonCollectionSequence}, а также заставьте {@link NonCollectionSequence} реализовать {@link Iterable}.
 * Продемонстрируйте, что все решения работают в командах <b>foreach</b>.
 *
 * @see NonCollectionSequence
 */
public class MultiIterableNonCollectionSequence {

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        for (Pet pet : nc) {
            System.out.print(pet + " ");
        }

        System.out.println("\nRandom order");

        for (Pet pet : nc.randomized()) {
            System.out.print(pet + " ");
        }

        System.out.println("\nReverse order");

        for (Pet pet : nc.reversed()) {
            System.out.print(pet + " ");
        }
    }
}
