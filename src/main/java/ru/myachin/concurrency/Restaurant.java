package ru.myachin.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 25. В класс <tt>Chef</tt> из примере <tt>Restaurant.java</tt> верните управление <tt>(return)</tt> из
 * {@link Runnable#run()} после вызова {@link ExecutorService#shutdownNow()}. Обратите внимание на различия в поведении
 * программы
 * <p>
 * 26. Добавьте в пример <tt>Restaurant.java</tt> класс <tt>BusyBoy</tt> ("уборщик"). После ого как блюдо будет
 * доставлено, класс <tt>WaitPerson</tt> должен оповестить <tt>BusyBoy</tt> о необходимости убрать.
 */
public class Restaurant {

    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    BusyBoy busyBoy = new BusyBoy(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
        exec.execute(busyBoy);
    }

    public static void main(String[] args) {
        new Restaurant();
    }

}

class Meal {

    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal " + orderNum;
    }

}

class WaitPerson implements Runnable {

    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                    }

                    System.out.println("Waitperson got " + restaurant.meal);

                    synchronized (restaurant.busyBoy) {
                        restaurant.busyBoy.notifyAll();
                    }

                    synchronized (restaurant.chef) {
                        restaurant.meal = null;
                        restaurant.chef.notifyAll();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }

}

class Chef implements Runnable {

    private Restaurant restaurant;

    private int count = 0;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }

                    if (++count == 10) {
                        System.out.println("Out of food, closing");
                        restaurant.exec.shutdownNow();
                        return;
                    }

                    System.out.print("Order up! ");
                    synchronized (restaurant.waitPerson) {
                        restaurant.meal = new Meal(count);
                        restaurant.waitPerson.notifyAll();
                    }

                    TimeUnit.MILLISECONDS.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }

}

class BusyBoy implements Runnable {

    private Restaurant restaurant;

    public BusyBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                    }

                    System.out.println("Busboy cleaned up " + restaurant.meal);
                    synchronized (restaurant.waitPerson) {
                        restaurant.waitPerson.notifyAll();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("BusyBoy interrupted");
        }
    }
}
