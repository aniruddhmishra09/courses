package org.courses.reactive.mono;

import org.courses.reactive.utils.CommonUtils;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Demo06_MonoUsingBlock {

    public static void main(String[] args) {

        System.out.println("Before : Using Mono.block");
        /*.block method uses Blocking subscriber which blocks the current thread & returns response
        In ideal case this should not be used*/
        String name = Demo06_MonoUsingBlock.getName().block();
        System.out.println("Generated name is - " + name);
        System.out.println("After : Using Mono.block");

    }

    private static Mono<String> getName() {
        System.out.println("Inside Name Generating Process");
        return Mono.fromSupplier(() -> {
            System.out.println("Start : Generating Name");
            CommonUtils.sleepThreadInSeconds(3);
            return CommonUtils.faker().name().fullName();
        });
    }
}
