package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * 11. Унаследуйте новый тип кнопки от класса {@link JButton}. Каждый раз при нажатии кнопки она должна менять свой
 * цвет на другой, котрый выбирается случайным образом. Чтобы узнать, как генерировать случайный цвет, найдите пример
 * <tt>ColorBoxes.java</tt> (см. далее в этой главе).
 */
public class RandomColorButton extends JButton {

    private static Random random = new Random(47);

    public RandomColorButton() {
        setText("ColoredButton");
        setBackground(new Color(random.nextInt(250), random.nextInt(250), random.nextInt(250)));
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBackground(new Color(random.nextInt(250), random.nextInt(250), random.nextInt(250)));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.add(new RandomColorButton());
        SwingConsole.run(frame, 250, 250);
    }
}