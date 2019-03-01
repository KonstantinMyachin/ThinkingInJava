package ru.myachin.reusing;

/**
 * 14. В <b>Car.java</b> добавьте в класс <b>Engine</b> метод <b>service()</b> и вызовите его из <b>main()</b>.
 */
public class Car {

    public Engine engine = new Engine();
    public Wheel[] wheel = new Wheel[4];
    public Door
            left = new Door(),
            right = new Door();

    public Car() {
        for (int i = 0; i < 4; i++) {
            wheel[i] = new Wheel();
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.left.window.rollup();
        car.wheel[0].inflate(72);
        car.engine.service();
    }
}

class Engine {

    public void start() {
    }

    public void rev() {
    }

    public void stop() {
    }

    public void service() {
    }

}

class Wheel {

    public void inflate(int psi) {
    }

}

class Window {

    public void rollup() {
    }

    public void rolldown() {
    }

}

class Door {

    public Window window = new Window();

    public void open() {
    }

    public void close() {
    }

}