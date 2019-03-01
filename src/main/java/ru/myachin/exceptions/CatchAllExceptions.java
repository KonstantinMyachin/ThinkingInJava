package ru.myachin.exceptions;

/**
 * 9. Создайте три новых типа исключений. Напишите класс с методом, возбуждающим каждое из них. В мтеоде
 * {@link #main(String[])} вызовите этот метод, используя одно предложение <tt>catch</tt>, способное перехватить все
 * три исключения.
 */
public class CatchAllExceptions {

    public static void main(String[] args) {
        try {
            throwCustomException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void throwCustomException() throws ExceptionOne, ExceptionTwo, ExceptionThree {
        throw new ExceptionOne();
//        throw new ExceptionTwo();
//        throw new ExceptionThree();
    }
}

class ExceptionOne extends Exception {

}

class ExceptionTwo extends Exception {

}

class ExceptionThree extends Exception {

}