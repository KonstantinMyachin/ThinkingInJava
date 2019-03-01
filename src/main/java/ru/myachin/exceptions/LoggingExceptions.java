package ru.myachin.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 6. Создайте два класса исключения, каждый из которых автоматически выводит информацию о себе. Продемонстрируйте, что
 * эти классы работают.
 */
public class LoggingExceptions {

    public static void main(String[] args) {
        new MyException();
        new MyException2();
    }
}

class MyException extends Exception {

    private static final Logger LOGGER = Logger.getLogger("ru.myachin.exceptions.MyException");

    public MyException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        LOGGER.severe(trace.toString());
    }
}

class MyException2 extends Exception {

    private static final Logger LOGGER = Logger.getLogger("ru.myachin.exceptions.MyException2");

    public MyException2() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        LOGGER.severe(trace.toString());
    }
}