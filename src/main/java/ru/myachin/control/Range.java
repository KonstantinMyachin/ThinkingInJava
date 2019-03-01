package ru.myachin.control;

/**
 * 6. Измените метод <b>test()</b> так, чтобы он получал два дополнительных аргумента <b>begin и end</b>, а значене
 * <b>testVal</b> проверялось на принадлежность к диапазону <b>[begin, end]</b> (с включением границ).
 */
public class Range {

    public static void main(String[] args) {
        System.out.println(test(5, 5, 6));
        System.out.println(test(10, 0, 9));
        System.out.println(test(15, 15, 15));
    }

    static boolean test(int testVal, int begin, int end) {
        if (begin > end) {
            throw new IllegalArgumentException(String.format("Конец отрезка %d не может быть больш начала %d",
                    end, begin));
        }
        return testVal >= begin && testVal <= end;
    }
}