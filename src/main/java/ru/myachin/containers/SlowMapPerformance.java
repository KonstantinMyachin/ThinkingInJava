package ru.myachin.containers;

import net.mindview.containers.MapPerformance;
import net.mindview.containers.SlowMap;
import net.mindview.containers.Tester;

/**
 * 35. Измените код {@link net.mindview.containers.MapPerformance} и включите в него тесты для реализации
 * {@link SlowMap}.
 */
public class SlowMapPerformance extends MapPerformance {
    public static void main(String[] args) {
        MapPerformance.main(args);
        //Tester.run(new SlowMap<>(), MapPerformance.tests); too much
        Tester.run(new CorrectedSlowMap<>(), MapPerformance.tests);
    }
}
