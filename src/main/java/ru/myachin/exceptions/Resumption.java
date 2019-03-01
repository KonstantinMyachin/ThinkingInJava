package ru.myachin.exceptions;

/**
 * 5. Создайте собственную реализацию модели возобновления, используя цикл <b>while</b>, который выполняется до тех пор,
 * пока исключение не перестанет выдываться.
 */
public class Resumption {

    public static void main(String[] args) {
        int i = 0;
        while (true) {
            if (i < 5) {
                try {
                    throw new Exception("5 is greater then " + i);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    i++;
                    continue;
                }
            }

            System.out.println("loop was exited successfully");
            break;
        }

        System.out.println("Program success");
    }
}