package ru.myachin.exceptions;

/**
 * 2. Определите ссылку на объект и присвойте ей значение <tt>null</tt>. Попробуйте вызвать метод объекта, пользуясь
 * этой ссылкой. Потом вставьте этот код в блок <b>try-catch</b> и перехватите исключение.
 */
public class NullReference {

    public static void main(String[] args) {
        String s = null;
        try {
            s.equals(null);
        } catch (NullPointerException e) {
            System.out.println("Handled NullPointerException");
        }
    }
}
