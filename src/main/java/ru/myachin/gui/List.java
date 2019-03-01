package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * 16. Упростите пример <tt>List.java</tt>: передайте массив конструктору и устраните динамическое включение элементов
 * в список.
 */
public class List extends JFrame {

    private String[] flavors = {
            "Chocolate", "Strawberry", "Vanilla Fudge Swirl",
            "Mint Chip", "Mocha Almond Fudge", "Rum Raisin",
            "Praline Cream", "Mud Pie"
    };

    @SuppressWarnings("unchecked")
    private JList lst = new JList(flavors);
    private JTextArea t = new JTextArea(flavors.length, 20);

    private ListSelectionListener ll = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            t.setText("");
            if (e.getValueIsAdjusting()) {
                return;
            }

            for (Object item : lst.getSelectedValuesList()) {
                t.append(item + "\n");
            }
        }
    };

    public List() {
        t.setEditable(false);
        setLayout(new FlowLayout());
        Border brd = BorderFactory.createMatteBorder(1, 1, 2, 2, Color.BLACK);
        lst.setBorder(brd);
        t.setBorder(brd);
        add(t);
        add(lst);
        lst.addListSelectionListener(ll);
    }

    public static void main(String[] args) {
        SwingConsole.run(new List(), 250, 375);
    }
}
