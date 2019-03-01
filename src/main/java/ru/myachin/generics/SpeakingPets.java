package ru.myachin.generics;

import net.mindview.generics.Apply;

import java.util.Arrays;
import java.util.List;

/**
 * 40. Добавьте метод <tt>speak()</tt> во все классы иерархии {@link net.mindview.typeinfo.pets.Pet}. Измените пример
 * <tt>Apply.java</tt>, чтобы метод <tt>speak()</tt> вызывался в нем для разнородной коллекции
 * {@link net.mindview.typeinfo.pets.Pet}.
 */
public class SpeakingPets {

    public static void main(String[] args) throws NoSuchMethodException {
        List<Pet> pets = Arrays.asList(
                new Rat(), new Pug(), new Mutt(), new Mouse(), new Manx(),
                new Hamster(), new EgyptianMau(), new Cymric());
        Apply.apply(pets, Pet.class.getMethod("speak"));
    }
}

class Rodent extends Pet {

    public Rodent(String name) {
        super(name);
    }

    public Rodent() {
        super();
    }
}

class Rat extends Rodent {

    public Rat(String name) {
        super(name);
    }

    public Rat() {
        super();
    }
}

class Pug extends Dog {

    public Pug(String name) {
        super(name);
    }

    public Pug() {
        super();
    }
}

class Mutt extends Dog {

    public Mutt(String name) {
        super(name);
    }

    public Mutt() {
        super();
    }
}

class Mouse extends Rodent {

    public Mouse(String name) {
        super(name);
    }

    public Mouse() {
        super();
    }
}

class Manx extends Cat {

    public Manx(String name) {
        super(name);
    }

    public Manx() {
        super();
    }
}

class Hamster extends Rodent {

    public Hamster(String name) {
        super(name);
    }

    public Hamster() {
        super();
    }
}

class EgyptianMau extends Cat {

    public EgyptianMau(String name) {
        super(name);
    }

    public EgyptianMau() {
        super();
    }
}

class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }

    public Dog() {
        super();
    }
}

class Cymric extends Manx {
    public Cymric(String name) {
        super(name);
    }

    public Cymric() {
        super();
    }
}

class Cat extends Pet {

    public Cat(String name) {
        super(name);
    }

    public Cat() {
        super();
    }
}