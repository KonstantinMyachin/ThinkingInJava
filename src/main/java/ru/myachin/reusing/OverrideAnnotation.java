package ru.myachin.reusing;

/**
 * 20. Продемонстрируйте, что аннотация {@link Override} решает следующую проблему:
 * Если метод объявлен как <b>private</b>, он не является частью интерфейса базового класса; это просто некоторый код,
 * скрытый внутри класса, у которого оказалось то же имя. Если вы создаете в производном классе одноименный метод со
 * спецификатром <b>public, protected</b> или с доступом в пределах пакета, то он никак не связан с хакрытым методом
 * базового класса.
 */
public class OverrideAnnotation {

    private void f() {
        System.out.println("OverrideAnnotation.f()");
    }
}

class OverrideAnnotationChild extends OverrideAnnotation {

    public static void main(String[] args) {
        new OverrideAnnotationChild().f();
    }

    //    @Override
    private void f() {
        System.out.println("OverrideAnnotationChild.f()");
    }
}
