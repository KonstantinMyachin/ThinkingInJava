package ru.myachin.holding;

import net.mindview.typeinfo.pets.Pet;
import net.mindview.typeinfo.pets.Pets;

import java.util.*;

public class NonCollectionSequence extends PetSequence implements Iterable<Pet> {

    public static void main(String[] args) {
        NonCollectionSequence nc = new NonCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
    }

    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < pets.length;
            }

            @Override
            public Pet next() {
                return pets[index++];
            }
        };
    }

    public Iterable<Pet> reversed() {
        return () -> new Iterator<Pet>() {

            private int index = pets.length;

            @Override
            public boolean hasNext() {
                return index > 0;
            }

            @Override
            public Pet next() {
                return pets[--index];
            }
        };
    }

    public Iterable<Pet> randomized() {
        List<Pet> list = new ArrayList<>(Arrays.asList(pets));
        Collections.shuffle(list, new Random(5));
        return list;
    }
}

class PetSequence {

    protected Pet[] pets = Pets.createArray(8);
}