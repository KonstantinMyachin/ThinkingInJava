package ru.myachin.typeinfo;

import net.mindview.typeinfo.factory.Factory;
import net.mindview.typeinfo.pets.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 15. Реализуйте новую версию {@link net.mindview.typeinfo.pets.PetCreator} с использованием регистрации фабрик.
 * Измените фасад {@link net.mindview.typeinfo.pets.Pets}, чтобы он мог использовать эту версию вместо двух других.
 * Убедитесь в том, что остальные примеры, использующие {@link net.mindview.typeinfo.pets.Pets} продолжают работать.
 */
public class PetCreator extends net.mindview.typeinfo.pets.PetCreator {

    private static Random random = new Random(47);
    private static List<Factory<? extends Pet>> petFactories = Arrays.asList(
            new Mutt.Factory(),
            new Pug.Factory(),
            new EgyptianMau.Factory(),
            new Cymric.Factory(),
            new Rat.Factory(),
            new Hamster.Factory()
    );

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new PetCreator().randomPet());
        }
    }

    @Override
    public List<Class<? extends Pet>> types() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Pet randomPet() {
        int n = random.nextInt(petFactories.size());
        return petFactories.get(n).create();
    }
}

class Cymric extends Manx {

    static class Factory implements net.mindview.typeinfo.factory.Factory<Cymric> {

        @Override
        public Cymric create() {
            return new Cymric();
        }
    }
}

class EgyptianMau extends Cat {

    static class Factory implements net.mindview.typeinfo.factory.Factory<EgyptianMau> {

        @Override
        public EgyptianMau create() {
            return new EgyptianMau();
        }
    }
}

class Hamster extends Rodent {

    static class Factory implements net.mindview.typeinfo.factory.Factory<Hamster> {

        @Override
        public Hamster create() {
            return new Hamster();
        }
    }
}

class Mutt extends Dog {

    static class Factory implements net.mindview.typeinfo.factory.Factory<Mutt> {

        @Override
        public Mutt create() {
            return new Mutt();
        }
    }
}

class Pug extends Dog {

    static class Factory implements net.mindview.typeinfo.factory.Factory<Pug> {

        @Override
        public Pug create() {
            return new Pug();
        }
    }
}

class Rat extends Rodent {

    static class Factory implements net.mindview.typeinfo.factory.Factory<Rat> {

        @Override
        public Rat create() {
            return new Rat();
        }
    }
}
