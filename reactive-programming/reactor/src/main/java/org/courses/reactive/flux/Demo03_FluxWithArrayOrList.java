package org.courses.reactive.flux;

import org.courses.reactive.utils.CommonUtils;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Demo03_FluxWithArrayOrList {
    public static void main(String[] args) {
        System.out.println("Creating Flux From List");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        System.out.println("Subscribing Flux From List");
        Flux.fromIterable(numbers)
                .subscribe(CommonUtils.onNextBehaviour());

        System.out.println("Creating Flux From Array");

        String[] alphabets = {"a", "b", "c", "d"};

        System.out.println("Subscribing Flux From Array");
        Flux.fromArray(alphabets)
                .subscribe(CommonUtils.onNextBehaviour());


    }
}
