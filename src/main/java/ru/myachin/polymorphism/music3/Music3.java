package ru.myachin.polymorphism.music3;

import ru.myachin.polymorphism.music.Instrument;
import ru.myachin.polymorphism.music.Note;
import ru.myachin.polymorphism.music.RandomInstrumentGenerator;

/**
 * 6. Измените программу <b>Music3.java</b> так, чтобы метод <b>what()</b> стал мтеодом корневого класса
 * {@link Object#toString()}. Попробуйте вывести информацию об объектах {@link Instrument} вызовом
 * <b>System.out.println</b> (без использования преобразований)
 * <p>
 * 7. Добавьте новый тип {@link Instrument} в программу <b>Music3.java</b>. Убедитесь в том, что полиморфизм работает
 * правильно и для этого нового типа.
 * <p>
 * 8. Измените программу <b>Music3.java</b>, чтобы в ней случайным образом генерировались объекты {@link Instrument},
 * как в программе {@link ru.myachin.polymorphism.shape.Shapes}.
 */
public class Music3 {

    public static void tune(Instrument i) {
        i.play(Note.MIDLE_C);
        System.out.println(i);
    }

    public static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
        }
    }

    public static void main(String[] args) {
        RandomInstrumentGenerator gen = new RandomInstrumentGenerator();
        Instrument[] orchestra = new Instrument[7];
        for (int i = 0, n = orchestra.length; i < n; i++) {
            orchestra[i] = gen.next();
        }
        tuneAll(orchestra);
    }
}