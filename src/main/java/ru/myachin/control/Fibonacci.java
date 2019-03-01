package ru.myachin.control;

/**
 * 9. <b><i>Числами Фибоначчи</i></b> называется числовая последовательность 1, 1, 2, 3, 5, 8, 13, 21, 34 и т.д., в
 * которой каждое число, начиная, с тертьего, является суумой двух предыдущх. Напшите метод, который получает
 * целочисленный аргумент и выводит указанное количество чисел Фибоначчи. Например, при запуске командой
 * <b>java Fibonacci 5(где Fibonacci - имя класса)</b> должно выводиться последовательность <b>1, 1, 2, 3, 5</b>.
 */
public class Fibonacci {

    public static void main(String[] args) {
//        args = new String[] {"25"};
        if (args.length != 1) {
            isNotExecutable();
        }

        try {
            int i = Integer.valueOf(args[0]);
            System.out.println(getFibonacci(i));
        } catch (NumberFormatException e) {
            isNotExecutable();
        }
    }

    private static void isNotExecutable() {
        throw new IllegalArgumentException("Программа должна запускаться с единственным аргументом - целым " +
                "числом больше 2.");
    }

    static String getFibonacci(int i) {
        if (i <= 2) {
            isNotExecutable();
        }

        StringBuilder sb = new StringBuilder("1, 1, ");
        int prePrevious = 1;
        int previous = 1;
        for (int j = 3; j <= i; j++) {
            int result = prePrevious + previous;
            prePrevious = previous;
            previous = result;

            sb.append(result);
            if (j != i) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}
