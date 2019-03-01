package ru.myachin.annotations;

import net.mindview.annotations.database.Constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 1. Реализуйте дополнительные типы SQL в {@link net.mindview.annotations.database.TableCreator примере с базой данных}
 */
public class TableCreator {
    public static void main(String[] args) throws Exception {
        net.mindview.annotations.database.TableCreator.main(args);
    }
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SQLBoolean {
    String name() default "";
    Constraints constraints() default @Constraints;
}

@interface SQLCharacter {
    int value() default 0;
    String name() default "";
    Constraints constraints() default @Constraints;
}