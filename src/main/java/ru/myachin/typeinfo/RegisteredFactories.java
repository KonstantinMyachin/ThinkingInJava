package ru.myachin.typeinfo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 14. Конструктор является разновидностью "Фабричного метода". Измените пример {@link net.mindview.typeinfo.RegisteredFactories}
 * так, чтобы вместо использования явно заданной фабрики объект клсса сохранялся в {@link java.util.List}, а для
 * создания каждого объекта использовался метод {@link Class#newInstance()}.
 */
public class RegisteredFactories {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }
}

class Part {

    private static Random random = new Random(47);

    static List<Class<? extends Part>> partClasses = Arrays.asList(
            FuelFilter.class,
            AirFilter.class,
            CabinAirFilter.class,
            OilFilter.class,
            FanBelt.class,
            GeneratorBelt.class,
            PowerSteeringBelt.class
    );

    static Part createRandom() {
        int n = random.nextInt(partClasses.size());
        try {
            return partClasses.get(n).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class Filter extends Part {}
class FuelFilter extends Filter {}
class AirFilter extends Filter {}
class CabinAirFilter extends Filter {}
class OilFilter extends Filter {}
class Belt extends Part {}
class FanBelt extends Belt {}
class GeneratorBelt extends Belt {}
class PowerSteeringBelt extends Belt {}