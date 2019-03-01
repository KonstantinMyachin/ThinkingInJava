package ru.myachin.polymorphism.music;

public class Instrument {

    public void play(Note n) {
        System.out.println("Instrument play() " + n);
    }

    String what() {
        return getClass().getSimpleName();
    }

    void adjust() {
        System.out.println("Adjusting Instrument");
    }

    @Override
    public String toString() {
        return what();
    }
}