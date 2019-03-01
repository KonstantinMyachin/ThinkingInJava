package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * 3. Измените пример <tt>SubmitSwingProgram.java</tt> так, чтобы в нем использовался класс {@link SwingConsole}.
 */
public class SubmitSwingProgram {

    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame();
        JLabel label = new JLabel("A Label");
        frame.add(label);

        SwingConsole.run(frame, 300, 100);
        TimeUnit.SECONDS.sleep(1);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                label.setText("Hey! This is Different!");
            }
        });

    }
}
