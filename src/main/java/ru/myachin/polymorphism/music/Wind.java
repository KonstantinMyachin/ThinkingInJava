package ru.myachin.polymorphism.music;

public class Wind extends Instrument {

    @Override
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Wind");
    }
}