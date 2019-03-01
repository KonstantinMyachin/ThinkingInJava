package ru.myachin.polymorphism;

/**
 * 9. Создайте иерархию наследования, используя в качестве основы различные типы грызунов. Базовым классом станет
 * <b>Rodent(грызун)</b>, а производными классами станут <b>Mouse(мышь), Hamster(хомяк)</b> и т. п. В базовм классе
 * определите несколько общих методов, которые потом переопределите в производных классах, для того, чтобы они
 * производили действия, свойственные конкретному типу объекта. Создайте массив из объектов <b>Rodent</b>, заполните
 * его различными производными типами и вызовите методы базового класса, чтобы увидеть результат работы программы.
 * <p>
 * 12. Измените упражнение 9 так, чтобы программа демонстрировала порядок инициализации базовых и производных классов.
 * Включите встроенные объекты и в базовые, и в производные классы, и покжаите, в каком порядке проходит их
 * инициализация при конструировании обхекта.
 * <p>
 * 15. Измените упражнение 12 так, чтобы один из встроенных объектов был общим и для него использовался подсчет ссылок.
 * Покажите, что он работает правильно.
 */
public class Rodents {

    public static void main(String[] args) {
        Member member = new Member();
        Rodent[] rodents = {
                new Mouse(member),
                new Hamster(member),
                new Gerbil(member)
        };

        for (Rodent rodent : rodents) {
            System.out.println(rodent);
            rodent.doSomething();
            rodent.reproduce();
            rodent.dispose();
        }
    }
}