package ru.myachin.operators;

/**
 * 13. Напишите метод для выода <b>char</b> в двоичном представлении. Продемонстрируйте его работу на нескольких разных
 * символах.
 */
public class BinaryChar {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString('a'));
        System.out.println(Integer.toBinaryString('b'));
        System.out.println(Integer.toBinaryString('^'));
        System.out.println(Integer.toBinaryString('&'));
        System.out.println(Integer.toBinaryString('1'));
        System.out.println(Integer.toBinaryString('0'));
        System.out.println(Integer.toBinaryString('!'));
    }
}