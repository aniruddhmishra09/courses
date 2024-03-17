package org.courses.reactive.mono;

import reactor.core.publisher.Mono;

public class Demo01_MonoJust {

    public static void main(String[] args) {
        //Publisher
        Mono<Integer> mono = Mono.just(1);
        System.out.println(mono);
        //Subscribing Mono - In Order to Publisher to emmit data , you have to subscribe
        mono.subscribe(i -> System.out.println("Received - " + i));
    }
}
