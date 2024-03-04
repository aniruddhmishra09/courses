package org.courses.reactive.mono;

import reactor.core.publisher.Mono;

public class Demo02_MonoSubscribe {
    public static void main(String[] args) {
        //Publisher
        Mono<String> mono = Mono.just("Circle");

        //Subscribing Publisher
        mono.subscribe(
                System.out::println,
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")
        );
    }
}
