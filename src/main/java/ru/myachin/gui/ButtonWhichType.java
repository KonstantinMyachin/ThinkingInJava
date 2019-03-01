package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 10. Создайте приложение на базе {@link SwingConsole}, с {@link JButton кнопкой} и {@link JTextField текстовым полем}.
 * Напишите и присоедините подходящего слушателя событий, так чтобы при получении кнопкой фокуса все вводимые в это время
 * с клавиатуры символы появлялись в тектовом окне
 */
public class ButtonWhichType extends JFrame {

    private JTextField textField = new JTextField(20);
    private JButton button = new JButton("Button Which Type");
    private JButton button2 = new JButton("Simple Button");

    public ButtonWhichType() {
        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                textField.setText(textField.getText() + e.getKeyChar());
            }
        });

        setLayout(new FlowLayout());
        add(textField);
        add(button);
        add(button2);

    }

    public static void main(String[] args) {
        SwingConsole.run(new ButtonWhichType(), 500, 500);
    }
}
