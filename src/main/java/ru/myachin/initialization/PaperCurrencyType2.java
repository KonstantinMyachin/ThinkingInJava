package ru.myachin.initialization;

/**
 * 22. Напишите команду <b>switch</b> для перечисления из {@link PaperCurrencyType предыдущего примера}. Для каждого
 * случая выведите расширенное описание конкретной валюты.
 */
public class PaperCurrencyType2 {

    public static void main(String[] args) {
        for (PaperCurrencyType.PaperCurrency paperCurrency : PaperCurrencyType.PaperCurrency.values()) {
            switch (paperCurrency) {
                case TEN:
                    System.out.println("Десять рублей");
                    break;
                case FIFTY:
                    System.out.println("Пятьдесят рублей");
                    break;
                case ONE_HUNDRED:
                    System.out.println("Cто рублей");
                    break;
                case FIVE_HUNDRED:
                    System.out.println("Пятьсот рублей");
                    break;
                case ONE_THOUSAND:
                    System.out.println("Тысяча рублей");
                    break;
                case FIVE_THOUSAND:
                    System.out.println("Пять тысяч рублей");
                    break;
                default:
                    System.out.println("Неизвестная купюра");
                    break;
            }
        }
    }
}
