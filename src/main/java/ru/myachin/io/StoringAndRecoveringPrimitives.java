package ru.myachin.io;

import java.io.*;

/**
 * 15. Найдите описания {@link DataOutputStream} и {@link DataInputStream} в документации <tt>JDK</tt>. На базе кода
 * <tt>StoringAndRecoveringData.java</tt> напишите програмуму, которая сохраняет, а затем читает все возможные типы,
 * поддерживаемые классами {@link DataOutputStream} и {@link DataInputStream}. Убедитесь в том, что запись и чтение
 * данных были выполнены правильно.
 */
public class StoringAndRecoveringPrimitives {

    public static void main(String[] args) {
        DataOutputStream out = null;
        DataInputStream in = null;
        try {
            String fileName = "Primitives.out";
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            out.writeBoolean(true);
            out.writeByte(1);
            out.writeShort(2);
            out.writeChar('c');
            out.writeInt(123);
            out.writeFloat(123.01f);
            out.writeLong(123L);
            out.writeDouble(123.02d);
            out.close();

            in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            System.out.println(in.readBoolean());
            System.out.println(in.readByte());
            System.out.println(in.readShort());
            System.out.println(in.readChar());
            System.out.println(in.readInt());
            System.out.println(in.readFloat());
            System.out.println(in.readLong());
            System.out.println(in.readDouble());
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
