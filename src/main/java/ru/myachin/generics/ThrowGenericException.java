package ru.myachin.generics;

import java.util.ArrayList;
import java.util.List;

interface Processor<T, E extends Exception, EXCEPTION extends Exception> {

    void process(List<T> resultCollector) throws E, EXCEPTION;
}

/**
 * 36. Добавьте в класс <tt>Processor</tt> второе параметризированное исключение и продемонстрируйте возможность
 * независимого изменения исключений.
 */
public class ThrowGenericException {

    public static void main(String[] args) {
        final ProcessRunner<String, Failure1, Failure2> runner = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner.add(new Processor1());
        }

        try {
            System.out.println(runner.processAll());
        } catch (Failure1 failure1) {
            System.out.println(failure1);
        } catch (Failure2 failure2) {
            System.out.println(failure2);
        }

        final ProcessRunner<Integer, Failure3, Failure4> runner2 = new ProcessRunner<>();
        for (int i = 0; i < 3; i++) {
            runner2.add(new Processor2());
        }

        try {
            System.out.println(runner2.processAll());
        } catch (Failure3 failure3) {
            System.out.println(failure3);
        } catch (Failure4 failure4) {
            System.out.println(failure4);
        }
    }
}

class ProcessRunner<T, E extends Exception, EXCEPTION extends Exception> extends ArrayList<Processor<T, E, EXCEPTION>> {

    List<T> processAll() throws E, EXCEPTION {
        final ArrayList<T> resultCollector = new ArrayList<>();
        for (Processor<T, E, EXCEPTION> processor : this) {
            processor.process(resultCollector);
        }

        return resultCollector;
    }
}

class Failure1 extends Exception {

}

class Failure2 extends Exception {

}

class Processor1 implements Processor<String, Failure1, Failure2> {

    static int count = 3;

    @Override
    public void process(List<String> resultCollector) throws Failure1, Failure2 {
        if (count-- > 1) {
            resultCollector.add("Hep!");
        } else {
            resultCollector.add("Ho!");
        }

        if (count < 0) {
            throw new Failure1();
        }

        throw new Failure2();
    }
}

class Failure3 extends Exception {

}

class Failure4 extends Exception {

}

class Processor2 implements Processor<Integer, Failure3, Failure4> {

    static int count = 2;

    @Override
    public void process(List<Integer> resultCollector) throws Failure3, Failure4 {
        if (count-- == 0) {
            resultCollector.add(47);
        } else {
            resultCollector.add(11);
        }

        if (count < 0) {
            throw new Failure3();
        }

        throw new Failure4();
    }
}