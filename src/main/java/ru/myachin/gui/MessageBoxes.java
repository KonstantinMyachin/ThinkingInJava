package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 18. Модифицируйте программу <tt>MessageBoxes.java</tt> так, чтобы она присоединяла к каждой кнопке отдельный
 * слушатель {@link ActionListener} (вместо сравнения текста на кнопках)
 */
public class MessageBoxes extends JFrame {

    private JButton[] b = {
            new JButton("Alert"), new JButton("Yes/No"),
            new JButton("Color"), new JButton("Input"),
            new JButton("3 Vals")
    };

    private JTextField txt = new JTextField(15);

    private MessageBoxes() {
        for (int i = 0, n = b.length; i < n; i++) {
            final int j = i;
            b[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch (j) {
                        case 0:
                            JOptionPane.showMessageDialog(null,
                                    "There's a bug on you!", "Hey!", JOptionPane.ERROR_MESSAGE);
                            break;
                        case 1:
                            JOptionPane.showConfirmDialog(null,
                                    "or no", "choose yes", JOptionPane.YES_NO_OPTION);
                            break;
                        case 2:
                            Object[] options = {"Red", "Green"};
                            int sel = JOptionPane.showOptionDialog(null, "Choose a Color!",
                                    "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                                    options, options[0]);
                            if (sel != JOptionPane.CLOSED_OPTION) {
                                txt.setText("Color Selected: " + options[sel]);
                            }
                            break;
                        case 3:
                            String val = JOptionPane.showInputDialog("How many fingers do you see?");
                            txt.setText(val);
                            break;
                        case 4:
                            Object[] selections = {"First", "Second", "Third"};
                            Object val2 = JOptionPane.showInputDialog(null, "Choose one",
                                    "Input", JOptionPane.INFORMATION_MESSAGE, null, selections, selections[0]);
                            if (val2 != null) {
                                txt.setText(val2.toString());
                            }
                            break;
                        default:
                    }
                }
            });
            add(b[i]);
        }
        setLayout(new FlowLayout());
    }

    public static void main(String[] args) {
        SwingConsole.run(new MessageBoxes(), 200, 200);
    }
}
