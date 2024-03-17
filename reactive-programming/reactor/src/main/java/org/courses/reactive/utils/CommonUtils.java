package org.courses.reactive.utils;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class CommonUtils {

    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNextBehaviour() {
        return obj -> System.out.println("RECEIVED - " + obj);
    }

    public static Consumer<Throwable> onErrorBehaviour() {
        return err -> System.out.println("ERROR - " + err.getMessage());
    }

    public static Runnable onCompleteBehaviour() {
        return () -> System.out.println("COMPLETED");
    }

    public static Faker faker() {
        return FAKER;
    }

    public static void sleepThreadInSeconds(int seconds) {
        System.out.println("Sleeping for " + seconds + " seconds");
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
