package ru.myachin.exceptions;

/**
 * 13. Измените {@link CatchAllExceptions упражнение 9}, добавив туда блок <tt>finally</tt>. Проверьте, что блок
 * выполняется даже в случае возбуждение {@link NullPointerException}.
 */
public class Finally {

    public static void main(String[] args) {
        try {
            CatchAllExceptions.throwCustomException();
        } catch (ExceptionOne exceptionOne) {
            exceptionOne.printStackTrace();
            throw new NullPointerException();
        } catch (ExceptionTwo exceptionTwo) {
            exceptionTwo.printStackTrace();
        } catch (ExceptionThree exceptionThree) {
            exceptionThree.printStackTrace();
        } finally {
            System.out.println("finally block are always executed");
        }
    }
}
