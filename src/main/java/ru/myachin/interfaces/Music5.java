package ru.myachin.interfaces;

import ru.myachin.polymorphism.music.Note;

/**
 * 9. Переделайте программу <b>Music5.java</b>, переместив общие метода <b>Wind, Percussion и Stringed</b> в
 * абстрактный класс.
 * 10. Измените программу <b>Music5.java</b>, добавив в нее интерфейс <b>Playable</b>. Переместите объявление
 * <b>play()</b> из класса <b>Instrument</b> в интерфейс <b>Playable</b>. Добавьте <b>Playable</b> к производным
 * классам, включив его в список <b>implements</b>. Измените метод <b>tune()</b> так, чтобы в аргументе ему
 * передавался интерфейс <b>Playable</b>, а не класс <b>Instrument</b>.
 */
public class Music5 {

    static void tune(Playable playable) {
        playable.play(Note.MIDLE_C);
    }

    static void tuneAll(Playable[] p) {
        for (Playable playable : p) {
            tune(playable);
        }
    }

    public static void main(String[] args) {
        Playable[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new WoodWind()
        };

        tuneAll(orchestra);
    }
}

interface Playable {

    void play(Note n);
}

abstract class Instrument implements Playable {

    void adjust() {
        System.out.println(this + ".adjust()");
    }

    @Override
    public void play(Note n) {
        System.out.println(this + ".play() " + n);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class Wind extends Instrument {}
class Percussion extends Instrument {}
class Stringed extends Instrument {}
class Brass extends Wind {}
class WoodWind extends Wind {}