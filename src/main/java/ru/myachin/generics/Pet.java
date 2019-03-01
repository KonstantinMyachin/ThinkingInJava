package ru.myachin.generics;

public class Pet extends net.mindview.typeinfo.pets.Pet {
    public Pet(String name) {
        super(name);
    }

    public Pet() {
        super();
    }

    public void speak() {
        System.out.println(this + " speak");
    }
}
