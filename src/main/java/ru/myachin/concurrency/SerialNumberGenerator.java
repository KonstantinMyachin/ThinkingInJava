package ru.myachin.concurrency;

/**
 * 13. Исправьте ошибку в <tt>SerialNumberChecker.java</tt>, используя ключевое слово <tt>synchronized</tt>. Сможете
 * ли вы продемонстрировать, что теперь программа работает верно?
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public static synchronized int nextSerialNumver() {
        return serialNumber++;
    }
}
