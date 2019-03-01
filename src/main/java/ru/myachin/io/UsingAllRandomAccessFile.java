package ru.myachin.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 16. Найдите описание {@link RandomAccessFile} в документации <tt>JDK</tt>. На базе кода
 * <tt>UsingRandomAccessFile.java</tt> напишите программу, которая сохраняет, а затем читает все возможные типы,
 * поддерживаемые классом {@link RandomAccessFile}. Убедитесь в том, что запись и чтение данных были выполнены
 * правильно.
 */
public class UsingAllRandomAccessFile {

    static String file = "RandomAccessDemonstration.out";

    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        System.out.println(rf.readBoolean());
        System.out.println(rf.readByte());
        System.out.println(rf.readUnsignedByte());
        System.out.println(rf.readChar());
        System.out.println(rf.readShort());
        System.out.println(rf.readUnsignedShort());
        System.out.println(rf.readInt());
        System.out.println(rf.readFloat());
        System.out.println(rf.readLong());
        System.out.println(rf.readDouble());
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        rf.writeBoolean(true);
        rf.writeByte(1);
        rf.writeByte(2);
        rf.writeChar('c');
        rf.writeShort(5);
        rf.writeShort(5);
        rf.writeInt(555);
        rf.writeFloat(3.33f);
        rf.writeLong(1L);
        rf.writeDouble(3.33);
        rf.writeUTF("The end of the file");
        rf.close();
        display();
    }
}
