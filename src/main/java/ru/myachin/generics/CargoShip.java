package ru.myachin.generics;

import net.mindview.generics.Generators;
import net.mindview.generics.Product;

import java.util.ArrayList;

/**
 * 19. По образцу {@link net.mindview.generics.Store} постройте модель грузового судна-контейнеровоза.
 */
public class CargoShip extends ArrayList<CargoHold> {

    private CargoShip(int nCargoHolds, int nContainers, int nProducts) {
        for (int i = 0; i < nCargoHolds; i++) {
            add(new CargoHold(nContainers, nProducts));
        }
    }

    public static void main(String[] args) {
        System.out.println(new CargoShip(14, 5, 10));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (CargoHold ch : this) {
            for (Container c : ch) {
                for (Product p : c) {
                    result.append(p);
                    result.append("\n");
                }
            }
        }

        return result.toString();
    }
}

class Container extends ArrayList<Product> {

    Container(int nProducts) {
        Generators.fill(this, Product.generator, nProducts);
    }
}

class CargoHold extends ArrayList<Container> {

    CargoHold(int nContainers, int nProducts) {
        for (int i = 0; i < nContainers; i++) {
            add(new Container(nProducts));
        }
    }
}