package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 17. Создайте прилоение с возможностью запуска инструментом {@link SwingConsole}. В документации
 * <a href="http://java.sun.com">JDK</a>, найдите описание текстового поля с паролем {@link JPasswordField} и добавьте
 * этот компонент на форму. Если пользователь набирает правильный пароль, выведите окно с подтвержающим это сообщением,
 * используя возможности {@link JOptionPane}
 */
public class Password extends JFrame {

    private JPasswordField password = new JPasswordField(10);
    private static final String CORRECT_PASSWORD = "123qwe";

    public Password() {
        password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = new String(((JPasswordField) e.getSource()).getPassword()).equals(CORRECT_PASSWORD) ?
                        "Correct Password" : "Incorrect password. Try again!";
                JOptionPane.showMessageDialog(null, msg, "Password Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        setLayout(new FlowLayout());
        add(new JLabel("Enter your password"));
        add(password);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Password(), 200, 100);
    }
}

