package ru.myachin.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 30. Внесите в программу <tt>CADState.java</tt> изменения, описанные в тексте:
 * <ol>
 * <li>Добавить статические методы <tt>serializeStaticState() и deserializeStaticState()</tt> во все фигуры
 * <tt>Shape</tt></li>
 * <li>Убрать из программы список <tt>shapeTypes</tt> и весь код, относящийся к нему</li>
 * <li>При сериализации и восстановлении вызывать новые методы для сохранения статической информации</li>
 * </ol>
 */
public class CorrectedCADState {

    public static void main(String[] args) throws Exception {
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shapes.add(Shape.randomFactory());
        }
        for (int i = 0; i < 10; i++) {
            ((Shape) shapes.get(i)).setColor(Shape.GREEN);
        }
        String fileName = "CADState.out";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        Circle.serializeStaticState(out);
        Square.serializeStaticState(out);
        Line.serializeStaticState(out);
        out.writeObject(shapes);
        System.out.println(shapes);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        Circle.deserializeStaticState(in);
        Square.deserializeStaticState(in);
        Line.deserializeStaticState(in);
        shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);
    }
}

abstract class Shape implements Serializable {

    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private static Random rand = new Random(47);
    private static int counter = 0;
    private int xPos, yPos, dimension;

    public Shape(int xVal, int yVal, int dim) {
        xPos = xVal;
        yPos = yVal;
        dimension = dim;
    }

    public static Shape randomFactory() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0:
                return new Circle(xVal, yVal, dim);
            case 1:
                return new Square(xVal, yVal, dim);
            case 2:
                return new Line(xVal, yVal, dim);
        }
    }

    public abstract int getColor();

    public abstract void setColor(int newColor);

    @Override
    public String toString() {
        return getClass() +
                "color[" + getColor() + "] xPos[" + xPos +
                "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }
}

class Circle extends Shape {
    private static int color;

    public Circle(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    public int getColor() {
        return color;
    }

    public void setColor(int newColor) {
        color = newColor;
    }
}

class Square extends Shape {
    private static int color;

    public Square(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }
}

class Line extends Shape {
    private static int color;

    public Line(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void setColor(int newColor) {
        color = newColor;
    }
}