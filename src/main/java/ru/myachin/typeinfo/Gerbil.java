package ru.myachin.typeinfo;

import net.mindview.typeinfo.pets.Rodent;

/**
 * 11. Добавьте класс <tt>Gerbil</tt> в библиотеку <tt>typeinfo.pets</tt> и измените все примеры этой главы так, чтобы
 * в них использовался новый класс.
 */
public class Gerbil extends Rodent {

    public Gerbil(String name) {
        super(name);
    }

    public Gerbil() {
    }
}