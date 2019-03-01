package ru.myachin.control;

/**
 * 10. <b><i>Вампирами</i></b> называются числа, состоящие из четного количества цифр и полученные переумноженем пары
 * чисел, каждое из которых содержит половину цифр результата. Цифры берутся из исходного числа в произвольном порядке,
 * завершающие нули недопустимы. Примеры:
 * <ol>
 * <li>1260 = 21 * 60</li>
 * <li>1827 = 21 * 87</li>
 * <li>2187 = 27 * 81</li>
 * </ol>
 * Напишите программу, которая находит всех "Вымпиров", состоящих из 4 цифр. (Задача предложена Деном Форханом.)
 */
public class Vampire {

    public static void main(String[] args) {
        for (int i = 1000; i < 10000; i++) {
            if (isVampire(i)) {
                System.out.println(i);
            }
        }
    }

    static boolean isVampire(int i) {
        if (i < 1000 || i >= 10000) {
            throw new IllegalArgumentException(String.format("Число %d не является четырехзначным положительным " +
                    "числом", i));
        }

        int fourth = i % 10;
        int third = (i % 100) / 10;
        int second = (i % 1000) / 100;
        int first = i / 1000;

        return concatTwoNumbers(first, second) * concatTwoNumbers(third, fourth) == i
                || concatTwoNumbers(first, second) * concatTwoNumbers(fourth, third) == i
                || concatTwoNumbers(second, first) * concatTwoNumbers(third, fourth) == i
                || concatTwoNumbers(second, first) * concatTwoNumbers(fourth, third) == i
                || concatTwoNumbers(first, third) * concatTwoNumbers(second, fourth) == i
                || concatTwoNumbers(first, third) * concatTwoNumbers(fourth, second) == i
                || concatTwoNumbers(third, first) * concatTwoNumbers(second, fourth) == i
                || concatTwoNumbers(third, first) * concatTwoNumbers(fourth, second) == i
                || concatTwoNumbers(first, fourth) * concatTwoNumbers(second, third) == i
                || concatTwoNumbers(first, fourth) * concatTwoNumbers(third, second) == i
                || concatTwoNumbers(fourth, first) * concatTwoNumbers(second, third) == i
                || concatTwoNumbers(fourth, first) * concatTwoNumbers(third, second) == i;
    }

    private static int concatTwoNumbers(int i, int j) {
        return Integer.valueOf("" + i + j);
    }
}