package ru.myachin.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 21. Напишите программу, которая получает данные из стандартного ввод и преобразует все символы к верхнему регистру,
 * после чего направляет результаты в стандартный вывод. Передайте программе содержимое файла (конкретный способ
 * перенаправления зиависит от вашей операционной системы).
 */
public class InputToUpperCaseOutput {

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            try {
                String s;
                while ((s = in.readLine()) != null && s.length() != 0) {
                    System.out.println(s.toUpperCase());
                }
                in.close();
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
