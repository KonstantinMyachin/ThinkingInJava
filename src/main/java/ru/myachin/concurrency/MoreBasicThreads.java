package ru.myachin.concurrency;

import net.mindview.concurrency.LiftOff;

/**
 * 8. Измените пример <tt>MoreBasicThreads.java</tt> так, чтобы все потоки выполнялись в режиме демона. Убедитесь в том,
 * что программа завершается сразу же после выхода из <tt>main()</tt>
 */
public class MoreBasicThreads {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LiftOff());
            thread.setDaemon(true);
            thread.start();
        }

        System.out.println("Waiting for LiftOff");
    }
}
