package ru.myachin.exceptions;

interface Storm {

    void event() throws RainedOut;

    void rainHard() throws RainedOut;
}

/**
 * 20. Измените программу <b>StormyInning.java</b>, добавив туда исключение типа <b>UmpireException</b> и методы,
 * возбуждающие это исключение. Протестриуйте получившуюся иерархию.
 *
 * @see Inning
 * @see Storm
 */
public class StormyInning extends Inning implements Storm {

    public StormyInning() throws RainedOut, BaseballException {

    }

    public StormyInning(String s) throws Foul, BaseballException {

    }

/*
    @Override
    public void walk() throws PopFoul {

    }
*/

/*
    public void event() throws RainedOut {

    }
*/

    @Override
    void decision() throws UmpireException {
        throw new UmpireException();
    }

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
            si.decision();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }

        try {
            Inning i = new StormyInning();
            i.atBat();
            i.decision();
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut rainedOut) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Общее исключение");
        }
    }

    public void rainHard() throws RainedOut {

    }

    @Override
    public void event() {

    }

    @Override
    public void atBat() throws PopFoul {

    }
}

class BaseballException extends Exception {

}

class Foul extends BaseballException {

}

class Strike extends BaseballException {

}

class UmpireException extends BaseballException {

}

abstract class Inning {
    public Inning() throws BaseballException {

    }

    public void event() throws BaseballException {

    }

    public abstract void atBat() throws Strike, Foul, UmpireException;

    public void walk() {

    }

    abstract void decision() throws UmpireException;
}

class StormException extends Exception {

}

class RainedOut extends StormException {

}

class PopFoul extends Foul {

}