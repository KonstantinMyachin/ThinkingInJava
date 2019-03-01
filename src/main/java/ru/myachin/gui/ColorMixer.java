package ru.myachin.gui;

import net.mindview.util.SwingConsole;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * 22. Создайте приложение с использованием {@link SwingConsole}. В нем должно быть три регулятора, каждый отвечает
 * соответственно за интенсивность красной, синей и зеленой составвляющей в цвете {@link Color}. Остальную часть формы
 * должна заполнить {@link JPanel}, закрашиваемая сформированным из значений трех регулярных цветов. Также добавьте три
 * три текстовых поля, недоступных для редактирования, в которых укажите текущие числовые значения составляющих цвета
 * RGB.
 */
public class ColorMixer extends JFrame {

    private ColorSlider red = new ColorSlider("Red");
    private ColorSlider green = new ColorSlider("Green");
    private ColorSlider blue = new ColorSlider("Blue");
    private JPanel color = new JPanel();

    private ColorMixer() {
        setLayout(new GridLayout(2, 1));
        JPanel jp = new JPanel(new FlowLayout());
        jp.add(red);
        jp.add(green);
        jp.add(blue);
        add(jp);
        add(color);
        color.setBackground(new Color(red.slider.getValue(), green.slider.getValue(), blue.slider.getValue()));
    }

    public static void main(String[] args) {
        SwingConsole.run(new ColorMixer(), 500  , 500);
    }

    class ColorSlider extends JPanel {
        JSlider slider;
        JTextField value;

        ColorSlider(String title) {
            super(new FlowLayout());
            slider = new JSlider(0, 255, 0);
            value = new JTextField(3);
            value.setEditable(false);
            add(new JLabel(title));
            add(slider);
            value.setText(String.format("%d", slider.getValue()));
            add(value);
            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    value.setText(String.format("%d", slider.getValue()));
                    color.setBackground(new Color(red.slider.getValue(), green.slider.getValue(), blue.slider.getValue()));
                }
            });
        }
    }
}
