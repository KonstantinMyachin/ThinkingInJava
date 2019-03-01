package ru.myachin.control;

/**
 * 4. Напишите программу, использующую два вложенных цикла <b>for</b> и оператор остатка <b>(%)</b> для поиска и вывода
 * простых чисел (то есть целых чисел, не делящихся нацело ни на какое другое число, кроме себя и 1)
 */
public class FindPrimes {

    public static void main(String[] args) {
        outer:
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            for (int j = 2; j <= i; j++) {
                if (i != j && (i % j) == 0) {
                    continue outer;
                }
            }

            System.out.println(i);
        }
    }
}
