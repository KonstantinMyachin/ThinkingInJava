package ru.myachin.generics;

import net.mindview.generics.Holder3;
import net.mindview.typeinfo.pets.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PetsHolderTest {

    @DataProvider(name = "petHierarchyClasses")
    public Object[] petHierarchyClasses() {
        return new Object[]{
                Mutt.class, Dog.class, Pug.class, Cat.class
        };
    }

    @Test(dataProvider = "petHierarchyClasses")
    public void testHoldingSubTypeClasses(Class<Pet> aClass) throws IllegalAccessException, InstantiationException {
        Holder3<Pet> petHolder = new Holder3<>(aClass.newInstance());
        assertEquals(aClass, petHolder.get().getClass());
    }
}