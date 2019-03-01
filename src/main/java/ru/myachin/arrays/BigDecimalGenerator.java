package ru.myachin.arrays;

import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 17. Создайте и протестируйте {@link Generator} для {@link BigDecimal}. Убедитесь в том, что он работает с методами
 * {@link Generated}
 */
public class BigDecimalGenerator implements Generator<BigDecimal> {

    private double value = 0.0;

    public static void main(String[] args) {
        final BigDecimal[] array = Generated.array(BigDecimal.class, new BigDecimalGenerator(), 10);
        System.out.println(Arrays.toString(array));
    }

    @Override
    public BigDecimal next() {
        double result = value;
        value += 1.0;

        return BigDecimal.valueOf(result);
    }
}
