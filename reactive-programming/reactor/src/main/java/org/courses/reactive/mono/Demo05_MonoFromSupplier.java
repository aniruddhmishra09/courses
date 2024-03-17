package org.courses.reactive.mono;

import org.courses.reactive.utils.CommonUtils;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Demo05_MonoFromSupplier {

    public static void main(String[] args) {

        System.out.println("Before : Using Mono.just");
        /*Mono.just should only be used when you already have data
        Ideally Publisher (in this case below line) it should not perform operation
        Whereas if we use Mono.jus it will perform action*/
        Mono.just(Demo05_MonoFromSupplier.getName());
        System.out.println("After : Using Mono.just");


        System.out.println("Before : Using Mono.fromSupplier");
        /*If Requirement is to perform some new action based on the Subscriber Demand
         Then Mono.fromSupplier should be used */
        Supplier<String> stringSupplier = () -> Demo05_MonoFromSupplier.getName();
        Mono<String> supplierMono = Mono.fromSupplier(stringSupplier);
        supplierMono.subscribe(CommonUtils.onNextBehaviour());
        System.out.println("After : Using Mono.fromSupplier");

        System.out.println("Before : Using Mono.fromCallable");
        Callable<String> stringCallable = () -> Demo05_MonoFromSupplier.getName();
        Mono<String> callableMono = Mono.fromCallable(stringCallable);
        callableMono.subscribe(CommonUtils.onNextBehaviour());
        System.out.println("After : Using Mono.fromCallable");


    }

    private static String getName() {
        System.out.println("Start : Generating Name");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End : Generated, Returning Name");
        return CommonUtils.faker().name().fullName();
    }
}
