package org.courses.reactive.flux;

import org.courses.reactive.utils.CommonUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Demo10_FluxToMono {
    public static void main(String[] args) {

        System.out.println("Before: Creating Flux");
        Flux<Integer> flux = Flux.range(1, 10);
        System.out.println("After: Creating Flux");


        System.out.println("Before: Creating Single Value from Flux");
        flux.next()
                .subscribe(CommonUtils.onNextBehaviour(),
                        CommonUtils.onErrorBehaviour(),
                        CommonUtils.onCompleteBehaviour());
        System.out.println("After: Creating Single Value from Flux");

    }
}
