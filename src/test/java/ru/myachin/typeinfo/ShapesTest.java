package ru.myachin.typeinfo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.myachin.polymorphism.shape.Circle;
import ru.myachin.polymorphism.shape.Shape;
import ru.myachin.polymorphism.shape.Square;
import ru.myachin.polymorphism.shape.Triangle;

public class ShapesTest {

    @DataProvider(name = "notRotatedShapes")
    public Object[] notRotatedShapes() {
        return new Object[] {
                new Shape(),
                new Square(),
                new Triangle(),
                new Rhomboid(),
        };
    }

    @Test(dataProvider = "notRotatedShapes", expectedExceptions = UnsupportedOperationException.class)
    public void failRotate(final Shape shape) {
        Shapes.rotate(shape);
    }

    @Test
    public void rotate() {
        Shapes.rotate(new Circle());
    }
}