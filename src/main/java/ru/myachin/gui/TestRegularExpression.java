package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 6. Преобразуйте пример <tt>strings/TestRegularExpression.java</tt> в интерактивную программу <tt>Swing</tt>, в
 * которой входная строка вводится в первой области {@link JTextArea}, а регулярное выржание - в поле {@link JTextField}.
 * Результат должен выводиться во второй области {@link JTextArea}
 */
public class TestRegularExpression extends JFrame {

    private JButton button = new JButton("Test Regular Expression");
    private JButton clearButton = new JButton("Clear All Fields");
    private JTextArea testedStringTextArea = new JTextArea(2, 40);
    private JTextArea resultTextArea = new JTextArea(20, 40);
    private JTextField regExpField = new JTextField(10);

    public TestRegularExpression() throws HeadlessException {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pattern p = Pattern.compile(regExpField.getText());
                Matcher m = p.matcher(testedStringTextArea.getText());
                while (m.find()) {
                    resultTextArea.append("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testedStringTextArea.setText("");
                resultTextArea.setText("");
                regExpField.setText("");
            }
        });

        setLayout(new FlowLayout());
        add(testedStringTextArea);
        add(regExpField);
        add(new JScrollPane(resultTextArea));
        add(button);
        add(clearButton);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TestRegularExpression(), 500, 500);
    }
}
