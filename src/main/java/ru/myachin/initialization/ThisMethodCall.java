package ru.myachin.initialization;

/**
 * 8. Создайте класс с двумя методами. В первом методе дважды вызовите второй метод: один раз без ключевого слова
 * <b>this</b>, а во второй с <b>this</b> - просто для того, чтобы убедиться в работоспособности этого синтаксиса; не
 * используйте этот способ вызова на практике
 */
public class ThisMethodCall {

    public static void main(String[] args) {
        ThisMethodCall methodCall = new ThisMethodCall();
        methodCall.doSomethingElse();
    }

    private void doSomething() {
        System.out.println("doSomething");
    }

    private void doSomethingElse() {
        doSomething();
        this.doSomething();
    }
}