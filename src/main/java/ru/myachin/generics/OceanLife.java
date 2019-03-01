package ru.myachin.generics;

import net.mindview.generics.Generators;
import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 18. По образцу <tt>BankTeller.java</tt> создайте пример, в котором в океане <tt>(Ocean)</tt> большие рыбы
 * <tt>(LittleFish)</tt> едят маленьких рыб <tt>(LittleFish)</tt>.
 */
public class OceanLife {

    public static void main(String[] args) {
        final Random random = new Random(47);
        List<LittleFish> littleFishList = new LinkedList<>();
        Generators.fill(littleFishList, LittleFish.generator(), 15);
        List<BigFish> bigFishList = new ArrayList<>();
        Generators.fill(bigFishList, BigFish.generator(), 4);
        for (LittleFish littleFish : littleFishList) {
            eat(bigFishList.get(random.nextInt(bigFishList.size())), littleFish);
        }
    }

    private static void eat(BigFish bigFish, LittleFish littleFish) {
        System.out.println(String.format("%s eat %s", bigFish, littleFish));
    }
}

class BigFish {

    private static long counter = 1;
    private final long id = counter++;

    private BigFish() {

    }

    public static Generator<BigFish> generator() {
        return new Generator<BigFish>() {
            @Override
            public BigFish next() {
                return new BigFish();
            }
        };
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class LittleFish {

    private static long counter = 1;
    private final long id = counter++;

    private LittleFish() {

    }

    public static Generator<LittleFish> generator() {
        return new Generator<LittleFish>() {
            @Override
            public LittleFish next() {
                return new LittleFish();
            }
        };
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
