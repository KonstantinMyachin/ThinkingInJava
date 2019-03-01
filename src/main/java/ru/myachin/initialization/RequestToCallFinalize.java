package ru.myachin.initialization;

/**
 * 11. Измените {@link FinalizeCall предыдущее упражнение так}, чтобы метод {@link FinalizeCall#finalize()} обязательно
 * был исполнен.
 */
public class RequestToCallFinalize {

    public static void main(String[] args) {
        new FinalizeCall();
        System.gc();
        System.runFinalization();
    }
}