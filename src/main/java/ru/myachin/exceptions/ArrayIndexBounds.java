package ru.myachin.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 3. Напишите код, который генерирует и перехватывает исключение {@link ArrayIndexOutOfBoundsException}.
 * <p>
 * 7. Измените упражнение 3 так, чтобы информация об исключении выводилась в блоке <tt>catch</tt>.
 * <p>
 * 27. Измените упражненеи 3 и преобразуйте исключение в {@link RuntimeException}
 */
public class ArrayIndexBounds {

    private static final Logger LOGGER = Logger.getLogger("ru.myachin.exceptions.ArrayIndexBounds");

    private static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        LOGGER.severe(trace.toString());
    }

    public static void main(String[] args) {
        int[] array = {};
        try {
            int i = array[-1];
        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Handled ArrayIndexOutOfBoundsException");
            logException(e);
            throw new RuntimeException(e);
        }
    }
}