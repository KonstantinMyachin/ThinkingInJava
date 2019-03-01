package ru.myachin.gui;

import javax.swing.JFrame;

/**
 * 1. Измените пример <tt>HelloSwing.java</tt> и продемонстрируйте, что приложение не закроется без вызова
 * {@link JFrame#setDefaultCloseOperation(int)}
 */
public class HelloSwing {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Swing");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}
