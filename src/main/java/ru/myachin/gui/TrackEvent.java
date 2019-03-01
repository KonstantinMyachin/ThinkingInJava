package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

/**
 * 12. Организуйте отслеживание еще одного события в программе <tt>TrackEvent.java</tt>, для чего напишите код,
 * обрабатывающий это событие. Самостоятельно выберите тип отслеживаемого события.
 */
public class TrackEvent extends JFrame {
    private HashMap<String, JTextField> h = new HashMap<String, JTextField>();
    private String[] event = {
            "actionPerformed", "focusGained", "focusLost", "keyPressed",
            "keyReleased", "keyTyped", "mouseClicked",
            "mouseEntered", "mouseExited", "mousePressed",
            "mouseReleased", "mouseDragged", "mouseMoved"
    };
    private MyButton b1 = new MyButton(Color.BLUE, "test1");
    private MyButton b2 = new MyButton(Color.RED, "test2");

    public TrackEvent() throws HeadlessException {
        setLayout(new GridLayout(event.length + 1, 2));
        for (String evt : event) {
            JTextField t = new JTextField();
            t.setEditable(false);
            add(new JLabel(evt, JLabel.RIGHT));
            add(t);
            h.put(evt, t);
        }
        add(b1);
        add(b2);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TrackEvent(), 700, 500);
    }

    class MyButton extends JButton {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                report("actionPerformed", e.paramString());
            }
        };
        FocusListener fl = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                report("focusGained", e.paramString());
            }

            @Override
            public void focusLost(FocusEvent e) {
                report("focusLost", e.paramString());
            }
        };
        KeyListener kl = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                report("keyPressed", e.paramString());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                report("keyReleased", e.paramString());
            }

            @Override
            public void keyTyped(KeyEvent e) {
                report("keyTyped", e.paramString());
            }
        };

        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                report("mouseClicked", e.paramString());
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                report("mouseEntered", e.paramString());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                report("mouseExited", e.paramString());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                report("mousePressed", e.paramString());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                report("mouseReleased", e.paramString());
            }
        };
        MouseMotionListener mml = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                report("mouseDragged", e.paramString());
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                report("mouseMoved", e.paramString());
            }
        };

        public MyButton(Color color, String label) {
            super(label);
            setBackground(color);
            addActionListener(al);
            addFocusListener(fl);
            addKeyListener(kl);
            addMouseListener(ml);
            addMouseMotionListener(mml);
        }

        void report(String field, String msg) {
            h.get(field).setText(msg);
        }
    }

}