package ru.myachin.polymorphism.music;

public class Woodwind extends Wind {

    @Override
    public void play(Note n) {
        System.out.println("Woodwind.play() " + n);
    }
}