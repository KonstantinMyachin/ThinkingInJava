package ru.myachin.generics;

/**
 * 30. Создайте объект {@link Holder} для каждой "обертки" примитивного типа. Продемонстрируйте, что автоматическая
 * упаковка и распаковка работает для методов <tt>set()</tt> и <tt>get()</tt> каждого экземпляра.
 */
public class AutoBoxingAndUnBoxing {

    public static void main(String[] args) {
        Holder<Boolean> booleanHolder = new Holder<>(false, false, false);
        booleanHolder.setFirst(true);
        boolean bool = booleanHolder.getFirst();
        System.out.println(bool);

        Holder<Byte> byteHolder = new Holder<>((byte) 1, (byte) 2, (byte) 3);
        byteHolder.setFirst((byte) 0);
        byte b = byteHolder.getFirst();
        System.out.println(b == 0);

        Holder<Short> shortHolder = new Holder<>((short) 1, (short) 2, (short) 3);
        shortHolder.setFirst((short) 0);
        short s = shortHolder.getFirst();
        System.out.println(s == 0);

        Holder<Character> characterHolder = new Holder<>('a', 'b', 'c');
        characterHolder.setFirst('A');
        char c = characterHolder.getFirst();
        System.out.println(c == 'A');

        Holder<Integer> intHolder = new Holder<>(1, 2, 3);
        intHolder.setFirst(0);
        int i = intHolder.getFirst();
        System.out.println(i == 0);

        Holder<Float> floatHolder = new Holder<>(1.0f, 2.0f, 3.0f);
        floatHolder.setFirst(0.0f);
        float f = floatHolder.getFirst();
        System.out.println(f == 0.0f);

        Holder<Long> longHolder = new Holder<>(1L, 2L, 3L);
        longHolder.setFirst(0L);
        long l = longHolder.getFirst();
        System.out.println(l == 0);

        Holder<Double> hd = new Holder<>(1.0, 2.0, 3.0);
        hd.setFirst(0.0);
        double d = hd.getFirst();
        System.out.println(d == 0.0);
    }
}
