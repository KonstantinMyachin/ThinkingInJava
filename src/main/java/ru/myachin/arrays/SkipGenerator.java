package ru.myachin.arrays;

import net.mindview.util.ConvertTo;
import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.util.Arrays;

/**
 * 16. Начав с {@link CountingGenerator}, создайте класс <tt>SkipGenerator</tt>, который создает новые значения
 * посредством приращения, определяемого аргументом конструктора. Измените пример <tt>TestArrayGeneration.java</tt> и
 * покажите, что новый класс работает правильно.
 */
public class SkipGenerator {

    static char[] chars = ("abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    public static void main(java.lang.String[] args) {
        int size = 6;
        boolean[] a1 =
                ConvertTo.primitive(Generated.array(java.lang.Boolean.class, new SkipGenerator.Boolean(true), size));
        System.out.println("a1 = " + Arrays.toString(a1));

        byte[] a2 =
                ConvertTo.primitive(Generated.array(java.lang.Byte.class, new SkipGenerator.Byte((byte) 2), size));
        System.out.println("a2 = " + Arrays.toString(a2));

        char[] a3 =
                ConvertTo.primitive(Generated.array(java.lang.Character.class, new SkipGenerator.Character(2), size));
        System.out.println("a3 = " + Arrays.toString(a3));

        short[] a4 =
                ConvertTo.primitive(Generated.array(java.lang.Short.class, new SkipGenerator.Short((short) 2), size));
        System.out.println("a4 = " + Arrays.toString(a4));

        int[] a5 =
                ConvertTo.primitive(Generated.array(java.lang.Integer.class, new SkipGenerator.Integer(2), size));
        System.out.println("a5 = " + Arrays.toString(a5));

        long[] a6 =
                ConvertTo.primitive(Generated.array(java.lang.Long.class, new SkipGenerator.Long(2), size));
        System.out.println("a6 = " + Arrays.toString(a6));

        float[] a7 =
                ConvertTo.primitive(Generated.array(java.lang.Float.class, new SkipGenerator.Float(2), size));
        System.out.println("a7 = " + Arrays.toString(a7));

        double[] a8 =
                ConvertTo.primitive(Generated.array(java.lang.Double.class, new SkipGenerator.Double(2), size));
        System.out.println("a8 = " + Arrays.toString(a8));
    }

    public static class Boolean implements Generator<java.lang.Boolean> {

        private boolean value;
        private boolean step;

        public Boolean(boolean step) {
            this.step = step;
        }

        @Override
        public java.lang.Boolean next() {
            value = step != value;
            return value;
        }
    }

    public static class Byte implements Generator<java.lang.Byte> {
        private byte value;
        private byte step;

        public Byte(byte step) {
            this.step = step;
        }

        @Override
        public java.lang.Byte next() {
            byte oldValue = value;
            value += step;
            return oldValue;
        }
    }

    public static class Character implements Generator<java.lang.Character> {

        int index;
        private int step;

        public Character(int step) {
            this.step = step;
        }

        @Override
        public java.lang.Character next() {
            char oldValue = chars[index];
            index = (index + step) % chars.length;
            return oldValue;
        }
    }

    public static class String implements Generator<java.lang.String> {

        Generator<java.lang.Character> cg;
        private int length;

        public String(int step) {
            this(step, 7);
        }

        public String(int step, int length) {
            this.length = length;
            cg = new Character(step);
        }

        @Override
        public java.lang.String next() {
            char[] buf = new char[length];
            for (int i = 0; i < length; i++) {
                buf[i] = cg.next();
            }
            return new java.lang.String(buf);
        }
    }

    public static class Short implements Generator<java.lang.Short> {

        private short value;
        private short step;

        public Short(short step) {
            this.step = step;
        }

        @Override
        public java.lang.Short next() {
            short oldValue = value;
            value += step;
            return oldValue;
        }
    }

    public static class Integer implements Generator<java.lang.Integer> {

        private int value;
        private int step;

        public Integer(int step) {
            this.step = step;
        }

        @Override
        public java.lang.Integer next() {
            int oldValue = value;
            value += step;
            return oldValue;
        }
    }

    public static class Long implements Generator<java.lang.Long> {

        private long value;
        private long step;

        public Long(long step) {
            this.step = step;
        }

        @Override
        public java.lang.Long next() {
            long oldValue = value;
            value += step;
            return oldValue;
        }
    }

    public static class Float implements Generator<java.lang.Float> {

        private float value;
        private float step;

        public Float(float step) {
            this.step = step;
        }

        @Override
        public java.lang.Float next() {
            float oldValue = value;
            value += step;
            return oldValue;
        }
    }

    public static class Double implements Generator<java.lang.Double> {

        private double value;
        private double step;

        public Double(double step) {
            this.step = step;
        }

        @Override
        public java.lang.Double next() {
            double oldValue = value;
            value += step;
            return oldValue;
        }
    }
}
