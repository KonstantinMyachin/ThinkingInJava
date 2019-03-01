package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * 21. Преобразуйте программу <tt>SineWave.java/tt> так, чтобы класс <tt>SineWave</tt> стал компонентом
 * <tt>JavaBean</tt>. Для этого определите в классе подходящиие <tt>get-</tt> и <tt>set-</tt> методы
 */
public class SineDraw extends JPanel {

    private static final int SCALE_FACTOR = 200;
    private int cycles;
    private int points;
    private double[] sines;
    private int[] pts;

    public SineDraw() {
        setCycles(5);
    }

    public static void main(String[] args) {
        SwingConsole.run(new SineWave(), 700, 400);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int maxWidth = getWidth();
        double hStep = (double) maxWidth / (double) points;
        int maxHeight = getHeight();
        pts = new int[points];
        for (int i = 0; i < points; i++) {
            pts[i] = (int) (sines[i] * maxHeight / 2 * .95 + maxHeight / 2);
        }
        g.setColor(Color.RED);
        for (int i = 1; i < points; i++) {
            int x1 = (int) ((i - 1) * hStep);
            int x2 = (int) (i * hStep);
            int y1 = pts[i - 1];
            int y2 = pts[i];
            g.drawLine(x1, y1, x2, y2);
        }
    }

    public int getCycles() {
        return cycles;
    }

    public void setCycles(int newCycles) {
        cycles = newCycles;
        points = SCALE_FACTOR * cycles * 2;
        sines = new double[points];
        for (int i = 0; i < points; i++) {
            double radians = (Math.PI / SCALE_FACTOR) * i;
            sines[i] = Math.sin(radians);
        }
        repaint();
    }
}

class SineWave extends JFrame {
    private SineDraw sines = new SineDraw();
    private JSlider adjustCycles = new JSlider(1, 30, 5);

    public SineWave() {
        add(sines);
        adjustCycles.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sines.setCycles(((JSlider) e.getSource()).getValue());
            }
        });
        add(BorderLayout.SOUTH, adjustCycles);
    }
}