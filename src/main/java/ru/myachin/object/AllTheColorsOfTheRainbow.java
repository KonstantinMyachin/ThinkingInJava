package ru.myachin.object;

import java.awt.*;

/**
 * 11. Преобразуйте пример с классом AllTheColorsOfTheRainbow в рабботающую прогармму.
 */
public class AllTheColorsOfTheRainbow {

    int anIntegerRepresentingColors;

    public static void main(String[] args) {
        AllTheColorsOfTheRainbow colorsOfTheRainbow = new AllTheColorsOfTheRainbow();
        colorsOfTheRainbow.changeTheHueOfTheColor(Color.CYAN.getRGB());
        System.out.println(colorsOfTheRainbow.anIntegerRepresentingColors);
    }

    void changeTheHueOfTheColor(int newHue) {
        anIntegerRepresentingColors = newHue;
    }
}
