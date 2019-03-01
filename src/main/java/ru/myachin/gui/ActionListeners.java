package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 7. Создайте приложение с использованием класс {@link SwingConsole} и добавьте все компоненты <tt>Swing</tt>,
 * содержащие метод <tt>addActionListener()</tt>. (Нужную информацию можно найти в документации
 * <a href="http://java.sun.com">JDK</a>. Подсказка: найдите имя метода <tt>addActionListener()</tt> в индексе.)
 * Организуйте перехват их событий и выведите для каждого события соответствующее сообщение в текстовом поле.
 */
public class ActionListeners extends JFrame {

    private JTextField textField = new JTextField( 20);
    private JButton button = new JButton("Button");
    private JComboBox comboBox = new JComboBox(new String[]{
            "first", "second", "third"
    });
    private JFileChooser fileChooser = new JFileChooser(".");

    public ActionListeners() throws HeadlessException {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Button was pushed");
            }
        });

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(comboBox.getSelectedItem() + " was selected");
            }
        });

        fileChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(fileChooser.getSelectedFile() + " was selected");
            }
        });

        setLayout(new FlowLayout());
        add(textField);
        add(button);
        add(comboBox);
        add(fileChooser);
    }

    public static void main(String[] args) {
        SwingConsole.run(new ActionListeners(), 500, 500);
    }
}

