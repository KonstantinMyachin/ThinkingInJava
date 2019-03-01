package ru.myachin.control;

/**
 * 7. Измените {@link ToOneHundred упражнение 1} так, чтобы выход из программы осуществлялся ключевым словом
 * <b>break</b> при значении <b>99</b>. Попробуйте использовать ключевое слово <b>return</b>.
 */
public class ToNinetyEight {

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i == 99) {
                break;
                //return;
            }

            System.out.println(i);
        }
    }
}