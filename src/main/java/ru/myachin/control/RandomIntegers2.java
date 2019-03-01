package ru.myachin.control;

import java.util.Random;

/**
 * 3. Измените {@link RandomIntegers упражнение 2} так, чтобы код выполнялся в "бесконечном" цикле <b>while</b>.
 * Программа должна работать до тех пор, пока ее выполнение не будет прервано с клавиатуры (как правило, нажатием
 * клавиш <b>CTRL+C</b>).
 */
public class RandomIntegers2 {

    public static void main(String[] args) {
        Random random = new Random();
        while (true) {
            RandomIntegers.compare(random.nextInt(), random.nextInt());
        }
    }
}