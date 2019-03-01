package ru.myachin.polymorphism.music;

public class Percussion extends Instrument {

    @Override
    public void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }

    @Override
    void adjust() {
        System.out.printf("Adjusting Percussion");
    }
}