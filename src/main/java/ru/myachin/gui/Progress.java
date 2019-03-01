package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * 32. Измените код <tt>Progress.java</tt>, чтобы вместо общей модели для связывания регулятора и индикатора выполнения
 * использовался слушатель.
 */
public class Progress extends JFrame {

    private JProgressBar progressBar = new JProgressBar();
    private JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 60);

    private Progress() {
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                progressBar.setValue(slider.getValue());
            }
        });

        setLayout(new GridLayout(2,1));
        add(progressBar);
        slider.setValue(0);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setBorder(new TitledBorder("Slide Me"));
        add(slider);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Progress(), 300, 200);
    }
}
