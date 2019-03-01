package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 29. В документиации JDK для пакета {@link javax.swing} найдите описание класса {@link JColorChooser}, который
 * отображает диалоговое окно для выбора цвета. Напишите программу с кнопкой, нажатие на которую открывает это
 * диалоговое окно на эран.
 */
public class ColorChooser extends JFrame {

    private ColorChooser() {
        setLayout(new FlowLayout());
        JButton button = new JButton("Color Chooser");
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser.showDialog(null, "Color Chooser", Color.LIGHT_GRAY);
            }
        });
    }

    public static void main(String[] args) {
        SwingConsole.run(new ColorChooser(), 250, 250);
    }
}
