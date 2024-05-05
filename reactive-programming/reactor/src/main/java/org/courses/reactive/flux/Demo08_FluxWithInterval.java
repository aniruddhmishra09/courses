package org.courses.reactive.flux;

import org.courses.reactive.utils.CommonUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Demo08_FluxWithInterval {
    public static void main(String[] args) {

        System.out.println("Before: Creating Flux With Interval");
        Flux.interval(Duration.ofSeconds(1)).subscribe(CommonUtils.onNextBehaviour());
        System.out.println("After: Creating Flux With Interval");
        CommonUtils.sleepThreadInSeconds(5);
    }
}
