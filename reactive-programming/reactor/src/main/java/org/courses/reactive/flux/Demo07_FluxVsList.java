package org.courses.reactive.flux;

import org.courses.reactive.helper.NameGeneratorHelper;
import org.courses.reactive.utils.CommonUtils;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Demo07_FluxVsList {
    public static void main(String[] args) {

        System.out.println("Before: Creating Names List");
        List<String> namesList = NameGeneratorHelper.getNamesAsList(5);
        System.out.println("After: Creating Names List");

        System.out.println("Before: Printing Names List");
        System.out.println(namesList);
        System.out.println("After: Printing Names List");



        System.out.println("Before: Creating Names Flux");
        Flux<String> namesFlux = NameGeneratorHelper.getNamesAsFlux(5);
        System.out.println("After: Creating Names Flux");

        System.out.println("Before: Printing Names Flux");
        System.out.println(namesFlux.subscribe(CommonUtils.onNextBehaviour()));
        System.out.println("After: Printing Names Flux");



    }
}
