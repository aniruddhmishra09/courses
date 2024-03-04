package org.courses.reactive.utils;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class CommonUtils {

    private static final Faker FAKER = Faker.instance();
    public static Consumer<Object> onNextBehaviour(){
        return obj -> System.out.println("Received - "+obj);
    }

    public static Consumer<Throwable> onErrorBehaviour(){
        return err -> System.out.println("Received - "+err.getMessage());
    }

    public static Runnable onCompleteBehaviour(){
        return () -> System.out.println("Completed");
    }

    public static Faker faker(){
        return FAKER;
    }
}
