package ru.myachin.polymorphism.music;

public class Stringed extends Instrument {

    @Override
    public void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Stringed");
    }
}