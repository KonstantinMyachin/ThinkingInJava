package ru.myachin.gui;

import net.mindview.util.Generator;
import net.mindview.util.RandomGenerator;
import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 14. Измените пример <tt>TextPane.java</tt> так, чтобы вместо {@link JTextPane} в нем использовался компонент
 * {@link JTextArea}
 */
public class UseTextArea extends JFrame {

    private static Generator<String> sg = new RandomGenerator.String(7);
    JTextArea textArea = new JTextArea();
    private JButton button = new JButton("Add Text");

    public UseTextArea() {
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i < 10; i++) {
                    textArea.setText(textArea.getText() + sg.next() + "\n");
                }
            }
        });
        add(new JScrollPane(textArea));
        add(BorderLayout.SOUTH, button);
    }

    public static void main(String[] args) {
        SwingConsole.run(new UseTextArea(), 475, 425);
    }
}
