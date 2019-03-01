package ru.myachin.exceptions;

/**
 * 8. Напишите класс с методом, который возбуждает исключение, созданное вами в {@link OwnException упражнении 4}.
 * Попробуйте откомпилировать код без спецификации исключений и посмотрите, что "скажет" компилятор. После этого
 * добавьте необходимую спецификацию исключений. Протестируйте свой класс и его исключение внутри блока
 * <tt>try-catch</tt>.
 */
public class ExceptionSpecification {

    public static void main(String[] args) {
        try {
            someMethod();
        } catch (OwnException e) {
            e.printMessage();
        }
    }

    static void someMethod() throws OwnException {
        throw new OwnException("My OwnException");
    }
}