package org.courses.reactive.mono;

import reactor.core.publisher.Mono;

public class Demo03_MonoSubscribeOnError {
    public static void main(String[] args) {
        //Publisher
        Mono<Integer> mono = Mono.just("Circle").map(String::length).map(record -> record/0);

        //Subscribing Publisher
        mono.subscribe(
                System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );
    }
}
