package ru.myachin.object;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class AllTheColorsOfTheRainbowTest {

    @Test
    public void testChangeColor() {
        AllTheColorsOfTheRainbow colorsOfTheRainbow = new AllTheColorsOfTheRainbow();
        colorsOfTheRainbow.changeTheHueOfTheColor(Color.BLACK.getRGB());
        assertEquals(new Color(colorsOfTheRainbow.anIntegerRepresentingColors), Color.BLACK);
    }
}