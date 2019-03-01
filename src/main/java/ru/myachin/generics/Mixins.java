package ru.myachin.generics;

import java.awt.*;
import java.util.Date;

/**
 * 37. Добавьте в <tt>Mixins.java</tt> новый класс примеси <tt>Colored</tt>. Подмешайте его в <tt>Mixin</tt> и покажите,
 * что программа работает.
 */
public class Mixins {

    public static void main(String[] args) {
        Mixin mixin = new Mixin();
        Mixin mixin2 = new Mixin();
        Mixin mixin3 = new Mixin();

        mixin.set("test string 1");
        mixin2.set("test string 2");
        mixin3.set("test string 3");

        mixin.setColor(Color.RED);
        mixin2.setColor(Color.GREEN);
        mixin3.setColor(Color.BLUE);

        System.out.println(String.format("%s %d %d %s",
                mixin.get(),
                mixin.getStamp(),
                mixin.getSerialNumber(),
                mixin.getColor()));
    System.out.println(String.format("%s %d %d %s",
                mixin2.get(),
                mixin2.getStamp(),
                mixin2.getSerialNumber(),
                mixin2.getColor()));
    System.out.println(String.format("%s %d %d %s",
                mixin3.get(),
                mixin3.getStamp(),
                mixin3.getSerialNumber(),
                mixin3.getColor()));
    }
}

interface TimeStamped {

    long getStamp();

}

interface SerialNumbered {

    long getSerialNumber();

}

interface Colored {

    void setColor(Color color);
    Color getColor();
}

interface Basic {


    void set(String val);
    String get();

}

class TimeStampedImpl implements TimeStamped {

    private final long timeStamp;

    public TimeStampedImpl() {
        this.timeStamp = new Date().getTime();
    }

    @Override
    public long getStamp() {
        return timeStamp;
    }
}

class SerialNumberedImpl implements SerialNumbered {

    private static long counter = 1;
    private final long serialNumber = counter++;

    @Override
    public long getSerialNumber() {
        return serialNumber;
    }
}

class ColoredImpl implements Colored {

    private Color color;

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}

class BasicImpl implements Basic {

    private String value;

    @Override
    public String get() {
        return value;
    }

    @Override
    public void set(String value) {
        this.value = value;
    }
}

class Mixin extends BasicImpl implements TimeStamped, SerialNumbered, Colored {

    private TimeStamped timeStamp = new TimeStampedImpl();
    private SerialNumbered serialNumber = new SerialNumberedImpl();
    private Colored colored = new ColoredImpl();

    @Override
    public long getStamp() {
        return timeStamp.getStamp();
    }

    @Override
    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }

    @Override
    public void setColor(Color color) {
        colored.setColor(color);
    }

    @Override
    public Color getColor() {
        return colored.getColor();
    }
}