package org.courses.reactive.flux;

import org.courses.reactive.utils.CommonUtils;
import reactor.core.publisher.Flux;

public class Demo01_FluxWithJust {
    public static void main(String[] args) {
        System.out.println("Creating Flux Object");

        Flux<Integer> flux = Flux.just(1,2,3,4);

        System.out.println("Subscribing Flux Object");
        flux.subscribe(CommonUtils.onNextBehaviour(),
                CommonUtils.onErrorBehaviour(),
                CommonUtils.onCompleteBehaviour());
    }
}
