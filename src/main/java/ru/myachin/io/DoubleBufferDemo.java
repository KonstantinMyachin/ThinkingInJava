package ru.myachin.io;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

/**
 * 24. Измените код <tt>IntBufferDemo.java</tt>, чтобы в нем использовался тип <tt>double</tt>.
 */
public class DoubleBufferDemo {

    public static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer db = bb.asDoubleBuffer();
        db.put(new double[]{
                11.1, 22.2, 33.3, 44.4, 55.5, 66.6, 77.7, 88.8, 99.9
        });
        System.out.println(db.get(3));
        db.put(3, 1811.11);
        db.flip();

        while (db.hasRemaining()) {
            System.out.println(db.get());
        }
    }
}
