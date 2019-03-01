package ru.myachin.gui;

/**
 * 37. Создайте ваш собственный компонент <tt>Bean</tt> с названием <tt>Valve</tt>, в котором определите два свойтсва:
 * логическое <tt>(boolean)</tt> значение с именем <tt>on</tt> и целое <tt>(int)</tt> с именем <tt>level</tt>.
 * Подготовьте манифест, запустите инструмент <tt>jar</tt> для упаковки компонента <tt>Bean</tt>, затем загрузите
 * полученный файл в программу <tt>Bean Builder</tt> или в среду разработки с поддержкой <tt>JavaBeans</tt> для
 * последующего тестирования.
 */
public class Valve {

    private boolean on;
    private int level;

    public Valve(boolean on, int level) {
        this.on = on;
        this.level = level;
    }

    public static void main(String[] args) {
        Valve valve = new Valve(true, 5);
        System.out.println(valve);
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "v.isOn() = " + on + " v.getLevel() = " + level;
    }
}
