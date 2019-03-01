package ru.myachin.generics;

import net.mindview.generics.Holder3;
import net.mindview.typeinfo.pets.Mutt;
import net.mindview.typeinfo.pets.Pet;

/**
 * 1. Используйте {@link Holder3} с библиотекой {@link net.mindview.typeinfo.pets} и продемонстрируйте, что объект
 * {@link Holder3}, объявленный с базовым типом, также может хранить производный тип.
 */
public class PetsHolder {

    public static void main(String[] args) {
        Holder3<Pet> petHolder = new Holder3<>(new Mutt("Mutt"));
        System.out.println(petHolder.get());
    }
}
