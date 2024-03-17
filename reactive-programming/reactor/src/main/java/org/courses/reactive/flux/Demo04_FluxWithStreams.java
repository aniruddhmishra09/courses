package org.courses.reactive.flux;

import org.courses.reactive.utils.CommonUtils;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo04_FluxWithStreams {
    public static void main(String[] args) {
        System.out.println("Creating numbers List");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        System.out.println("Creating Streams of List");

        Stream<Integer> integerStream = numbers.stream();

        System.out.println("Creating Flux by passing Streams Directly");

        Flux<Integer> integerFlux = Flux.fromStream(integerStream);

        System.out.println("Subscribing Flux with Stream for 1st time");

        integerFlux.subscribe(CommonUtils.onNextBehaviour(),
                CommonUtils.onErrorBehaviour(),
                CommonUtils.onCompleteBehaviour());

        System.out.println("Subscribing Flux with Stream for 2nd time");

        /*As streams can not be accessed twice, below code will throw an error*/
        integerFlux.subscribe(CommonUtils.onNextBehaviour(),
                CommonUtils.onErrorBehaviour(),
                CommonUtils.onCompleteBehaviour());

        System.out.println("Creating Flux by passing Streams as a Supplier");

        Flux<Integer> integerFluxForMultipleAccess = Flux.fromStream(numbers::stream);

        System.out.println("Subscribing Flux with Stream As Supplier for 1st time");

        integerFluxForMultipleAccess.subscribe(CommonUtils.onNextBehaviour(),
                CommonUtils.onErrorBehaviour(),
                CommonUtils.onCompleteBehaviour());

        System.out.println("Subscribing Flux with Stream As Supplier for 2nd time");

        integerFluxForMultipleAccess.subscribe(CommonUtils.onNextBehaviour(),
                CommonUtils.onErrorBehaviour(),
                CommonUtils.onCompleteBehaviour());

    }
}
