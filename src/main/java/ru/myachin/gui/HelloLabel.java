package ru.myachin.gui;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 2. Измените пример <tt>HelloLabel.java</tt> и продемонстрируйте, что добавление надписей осуществляется динамически,
 * добавляя случайное количество надписей.
 */
public class HelloLabel {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random(47);
        JFrame frame = new JFrame("Hello Swing");
        JLabel label = new JLabel("A label");
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
        TimeUnit.SECONDS.sleep(1);
        for (int i = 0, n = random.nextInt(50); i < n; i++) {
            label.setText(Integer.toString(i));
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
