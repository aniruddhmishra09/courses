package org.courses.reactive.flux;

import org.courses.reactive.utils.CommonUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Demo09_FluxFromMono {
    public static void main(String[] args) {

        System.out.println("Before: Creating Mono");
        Mono<String> mono = Mono.just("abc");
        System.out.println("After: Creating Mono");

        System.out.println("Before: Creating Flux from Mono");
        Flux<String> flux = Flux.from(mono);
        System.out.println("After: Creating Flux from Mono");

        flux.subscribe(CommonUtils.onNextBehaviour());
    }
}
