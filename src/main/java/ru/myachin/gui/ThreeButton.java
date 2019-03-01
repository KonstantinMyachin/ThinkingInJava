package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 5. Создайте приложение с использованеим класса {@link SwingConsole}. Разместите одно текстовое поле и три кнопки.
 * При нажатии каждой кнопки в текстовом поле должен появляться соответствующий текст.
 * <p>
 * 15. Добавьте флажок к приложению, созданному в упражнении 5, обработайте его событие и поместите в тектовое поле
 * другой текст
 */
public class ThreeButton extends JFrame {

    private JButton b1 = new JButton("Button 1");
    private JButton b2 = new JButton("Button 2");
    private JButton b3 = new JButton("Button 3");
    private JTextField field = new JTextField(10);
    private JCheckBox checkBox = new JCheckBox("CheckBox");
    private ActionListener buttonAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            field.setText(((JButton) e.getSource()).getText());
        }
    };

    public ThreeButton() throws HeadlessException {
        checkBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                field.setText(((JCheckBox) e.getSource()).isSelected() ? "Checked" : "Unchecked");
            }
        });

        b1.addActionListener(buttonAction);
        b2.addActionListener(buttonAction);
        b3.addActionListener(buttonAction);
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
        add(field);
        add(checkBox);
    }

    public static void main(String[] args) {
        SwingConsole.run(new ThreeButton(), 200, 150);
    }
}
