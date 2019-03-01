package ru.myachin.object;

/**
 * 5. Измените упражнение 4 так, чтобы данным класса DataOnly присваивались значения, а затем распечатайте их в методе
 * main().
 */
public class DataOnly2 {

    int i = 5;
    double d = 5.5;
    boolean b = true;

    public static void main(String[] args) {
        DataOnly2 dataOnly = new DataOnly2();
        System.out.println(dataOnly.i);
        System.out.println(dataOnly.d);
        System.out.println(dataOnly.b);
    }

}