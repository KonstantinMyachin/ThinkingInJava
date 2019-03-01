package ru.myachin.generics;

import net.mindview.generics.RandomList;
import net.mindview.typeinfo.pets.Pet;
import ru.myachin.typeinfo.PetCreator;

/**
 * 6. Используйте {@link RandomList} еще с двуяя типами (кроме представленного в {@link RandomList#main(String[])}
 */
public class RandomListTest {

    public static void main(String[] args) {
        final RandomList<Integer> randomList = new RandomList<>();
        final int n = 10;
        for (int i = 0; i < n; i++) {
            randomList.add(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(randomList.select() + " ");
        }

        final RandomList<Pet> petRandomList = new RandomList<>();
        final PetCreator petCreator = new PetCreator();

        System.out.println();
        for (int i = 0; i < n; i++) {
            petRandomList.add(petCreator.randomPet());
        }

        for (int i = 0; i < n; i++) {
            System.out.print(petRandomList.select() + " ");
        }
    }
}
