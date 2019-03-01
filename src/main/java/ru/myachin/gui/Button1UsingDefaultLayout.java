package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.awt.*;

/**
 * 4. Покажите, что без вызова {@link JFrame#setLayout(LayoutManager)} в <tt>Button1.java</tt> в программе появится
 * только одна кнопка.
 */
public class Button1UsingDefaultLayout {

    public static void main(String[] args) {
        SwingConsole.run(new Button1(), 200, 100);
    }
}

class Button1 extends JFrame {
    private JButton b1 = new JButton("Button 1");
    private JButton b2 = new JButton("Button 2");

    public Button1() throws HeadlessException {
//        setLayout(new FlowLayout());
        add(b1);
        add(b2);
    }
}