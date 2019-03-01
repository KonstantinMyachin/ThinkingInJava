package ru.myachin.exceptions;

/**
 * 25. Создайте трехуровневую иерархию исключений. Далее сделайте базовый класс <b>A</b> с методом, который возбуждает
 * исключение, являющееся основой иерархии. Унаследуйте класс <b>B</b> от <b>A</b> и переопределите метод так, чтобы
 * он возбуждал исключение из второго уровня иерархии. Аналогично поступите при наследовании класса <b>C</b> от <b>B</b>
 * В методе <b>main()</b> создайте класс <b>C</b>, проведите восходящее преобразование к классу <b>A</b>, а затем
 * вызовите метод.
 */
public class ThreeLevelException {

    public static void main(String[] args) {
        A c = new C();
        try {
            c.throwException();
        } catch (FirstLevelException e) {
            System.out.println(e);
        }
    }
}

class FirstLevelException extends Exception {

}

class SecondLevelException extends FirstLevelException {

}

class ThirdLevelException extends SecondLevelException {

}

class A {

    void throwException() throws FirstLevelException {
        throw new FirstLevelException();
    }
}

class B extends A {

    @Override
    void throwException() throws SecondLevelException {
        throw new SecondLevelException();
    }
}

class C extends B {

    @Override
    void throwException() throws ThirdLevelException {
        throw new ThirdLevelException();
    }
}