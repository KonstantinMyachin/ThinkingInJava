package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.awt.*;

/**
 * 30. Напишите программу, демонстрирующую использование текста в формате <tt>HTML</tt> для всех компонентов,
 * перечисленных в предыдущем абзаце: <ul><li>{@link JTabbedPane}</li><li>{@link JMenuItem}</li>
 * <li>{@link JTabbedPane}</li><li>{@link JToolTip}</li><li>{@link JRadioButton}</li><li>{@link JCheckBox}</li></ul>
 */
public class HTMLComponents extends JFrame {

    private HTMLComponents() {
        setLayout(new FlowLayout());
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("<html><font size=+1>Tab 1", new JCheckBox("<html><u>Check me!"));
        tabs.addTab("<html><font size=-1>Tab 2", new JRadioButton("<html><i>Click me!"));
        add(tabs);
        JMenuItem[] items = {
                new JMenuItem("Text Item"),
                new JMenuItem("<html><b><font size=+1>HTML Item")
        };
        items[1].setToolTipText("<html><center>Dummy Item<br><i>No action");
        JMenu[] menus = {
                new JMenu("Text"), new JMenu("<html><i>HTML")
        };
        menus[0].add(items[0]);
        menus[1].add(items[1]);
        JMenuBar mb = new JMenuBar();
        mb.add(menus[0]);
        mb.add(menus[1]);
        setJMenuBar(mb);
    }

    public static void main(String[] args) {
        SwingConsole.run(new HTMLComponents(), 250, 250);
    }
}
