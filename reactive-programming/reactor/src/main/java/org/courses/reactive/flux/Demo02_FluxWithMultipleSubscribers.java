package org.courses.reactive.flux;

import reactor.core.publisher.Flux;

public class Demo02_FluxWithMultipleSubscribers {
    public static void main(String[] args) {
        System.out.println("Creating Flux Object");

        Flux<Integer> flux = Flux.just(1, 2, 3, 4);

        System.out.println("Subscribing Flux Object");

        flux.subscribe(i -> System.out.println("Subscriber 1 - " + i));

        flux.subscribe(i -> System.out.println("Subscriber 2 - " + i));
    }
}
