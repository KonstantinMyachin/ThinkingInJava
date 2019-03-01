package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.awt.*;

/**
 * 8. Почти все компоненты <tt>Swing</tt> являются производными от класс {@link Component}, содержащего метод
 * {@link Component#setCursor(Cursor)}. Найдите этот метод в документации <tt>JDK</tt>. Созадайте приложение и змените
 * указатель мыши одним из стандартных указателей класса {@link Cursor}
 */
public class ChangeCursor extends JFrame {

    private JButton button = new JButton("Button");

    public ChangeCursor() throws HeadlessException {
        setLayout(new FlowLayout());
        add(button);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }

    public static void main(String[] args) {
        SwingConsole.run(new ChangeCursor(), 500, 200);
    }
}
