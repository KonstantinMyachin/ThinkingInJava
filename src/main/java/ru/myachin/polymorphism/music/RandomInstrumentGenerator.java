package ru.myachin.polymorphism.music;

import java.util.Random;

public class RandomInstrumentGenerator {

    private final Random random = new Random(47);

    public Instrument next() {
        switch (random.nextInt(7)) {
            case 1:
                return new Brass();
            case 2:
                return new OneMoreInstrument();
            case 3:
                return new Percussion();
            case 4:
                return new Stringed();
            case 5:
                return new Wind();
            case 6:
                return new Woodwind();
            default:
                return new Instrument();
        }
    }
}
