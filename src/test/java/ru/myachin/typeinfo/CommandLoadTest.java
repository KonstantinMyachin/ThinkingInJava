package ru.myachin.typeinfo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CommandLoadTest {

    @DataProvider(name = "sweetItems")
    public Object[] sweetItems() {
        return new Object[] {
                "Candy", "Gum", "Cookie"
        };
    }

    @DataProvider(name = "nonExistentItems")
    public Object[] nonExistentItems() {
        return new Object[] {
                "Candy1", "Gum1", "Cookie1"
        };
    }

    @Test(dataProvider = "sweetItems")
    public void createInstance(final String item) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        CommandLoad.main(new String[] {item});
    }

    @Test(dataProvider = "nonExistentItems", expectedExceptions = ClassNotFoundException.class)
    public void notFoundItemClass(final String item) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        CommandLoad.main(new String[] {item});
    }
}