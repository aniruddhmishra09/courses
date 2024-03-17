package org.courses.reactive.flux;

import org.courses.reactive.utils.CommonUtils;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo05_FluxWithRange {
    public static void main(String[] args) {
        System.out.println("Creating Flux with Range Starting from 1");
        Flux.range(1, 10)
                .subscribe(CommonUtils.onNextBehaviour(),
                        CommonUtils.onErrorBehaviour(),
                        CommonUtils.onCompleteBehaviour());

        System.out.println("Creating Flux with Range Starting from 3");
        Flux.range(3, 15)
                .subscribe(CommonUtils.onNextBehaviour(),
                        CommonUtils.onErrorBehaviour(),
                        CommonUtils.onCompleteBehaviour());
    }
}
