package ru.myachin.concurrency;

import net.mindview.concurrency.Daemons;

import java.lang.reflect.Constructor;
import java.util.concurrent.TimeUnit;

/**
 * 7. Поэкспериментируйте с разным временем ожидания в {@link Daemons} и посмотрите, что при этом происходит.
 */
public class DemonstrateDaemons {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("net.mindview.concurrency.Daemon");
        Constructor<?> constructor = aClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        Thread d = new Thread(((Runnable) constructor.newInstance()));
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");

//        TimeUnit.MILLISECONDS.sleep(1);
//        TimeUnit.MILLISECONDS.sleep(2);
        TimeUnit.MILLISECONDS.sleep(3);
//        TimeUnit.MILLISECONDS.sleep(4);
    }
}
