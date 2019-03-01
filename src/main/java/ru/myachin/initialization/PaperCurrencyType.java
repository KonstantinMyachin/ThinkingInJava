package ru.myachin.initialization;

/**
 * 21. Создайте перечисление с названиями шести типов бумажных денег. Переберите результат <b>values()</b> с выводом
 * каждого значения и его <b>ordinal()</b>.
 */
public class PaperCurrencyType {

    public static void main(String[] args) {
        for (PaperCurrency paperCurrency : PaperCurrency.values()) {
            System.out.println(paperCurrency + " ordinal = " + paperCurrency.ordinal());
        }
    }

    enum PaperCurrency {
        TEN, FIFTY, ONE_HUNDRED, FIVE_HUNDRED, ONE_THOUSAND, FIVE_THOUSAND
    }
}