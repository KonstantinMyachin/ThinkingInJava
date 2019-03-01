package ru.myachin.polymorphism.music;

public class OneMoreInstrument extends Instrument {

    @Override
    public void play(Note n) {
        System.out.println("OneMoreInstrument.play() " + n);
    }
}