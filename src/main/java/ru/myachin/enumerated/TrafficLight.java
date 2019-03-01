package ru.myachin.enumerated;

import static ru.myachin.enumerated.Signal.*;

enum Signal {
    GREEN, YELLOW, RED
}

/**
 * 1. Используйте директиву статического импортирования и измените пример <tt>TrafficLight.java</tt> так, чтобы
 * экземпляры перечисления могли использоваться без уточнения.
 */
public class TrafficLight {

    Signal color = RED;

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }

    public void change() {
        switch (color) {
            case RED:
                color = GREEN;
                break;
            case GREEN:
                color = YELLOW;
                break;
            case YELLOW:
                color = RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }
}