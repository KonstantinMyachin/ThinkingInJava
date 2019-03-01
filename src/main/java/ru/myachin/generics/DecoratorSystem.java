package ru.myachin.generics;

import java.awt.*;

/**
 * 38. Создайте простую систему декораторов: начните с базового типа <tt>Coffee</tt>, а затем добавьте декораторы для
 * разных кофейных напитков: капучино, с декоративной пенкой, с шоколадом, с карамелью и взбитыми сливками.
 */
public class DecoratorSystem {

    public static void main(String[] args) {
        CoffeeDecorator cappuccino = new Foam(new SteamedMilk(new BasicCoffee("espresso")));
        System.out.println("Capuccino is: " + cappuccino.getType());
        CoffeeDecorator whiteChocolateCoffee = new WhippedCream(new Chocolate(new BasicCoffee("hot coffee"), Color.WHITE));
        System.out.println("White Chocolate Coffee is: " + whiteChocolateCoffee.getType());
    }
}

class BasicCoffee {

    private String type;

    BasicCoffee() {
    }

    public BasicCoffee(String type) {
        setType(type);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class CoffeeDecorator extends BasicCoffee {

    private BasicCoffee basic;

    CoffeeDecorator(BasicCoffee basic) {
        this.basic = basic;
    }

    @Override
    public String getType() {
        return basic.getType();
    }

    @Override
    public void setType(String type) {
        basic.setType(type);
    }
}

class SteamedMilk extends CoffeeDecorator {

    public SteamedMilk(BasicCoffee basic) {
        super(basic);
        setType(getType() + " & steamed milk");
    }
}

class Foam extends CoffeeDecorator {

    public Foam(BasicCoffee basic) {
        super(basic);
        setType(getType() + " & foam");
    }
}

class Chocolate extends CoffeeDecorator {

    private final Color color;

    public Chocolate(BasicCoffee basic, Color color) {
        super(basic);
        this.color = color;
        setType(getType() + " & chocolate[color = " +
                getColor() + "]");
    }

    private Color getColor() {
        return color;
    }
}

class Caramel extends CoffeeDecorator {

    public Caramel(BasicCoffee basic) {
        super(basic);
        setType(getType() + " & caramel");
    }
}

class WhippedCream extends CoffeeDecorator {

    public WhippedCream(BasicCoffee basic) {
        super(basic);
        setType(getType() + " & whipped cream");
    }
}