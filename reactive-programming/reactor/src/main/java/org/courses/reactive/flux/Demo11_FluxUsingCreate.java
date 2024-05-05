package org.courses.reactive.flux;

import org.courses.reactive.utils.CommonUtils;
import reactor.core.publisher.Flux;

public class Demo11_FluxUsingCreate {
    public static void main(String[] args) {

        System.out.println("Before: Creating Flux with Create");

        Flux.create(fluxSink -> {
            fluxSink.next(1);
            fluxSink.next(2);
            fluxSink.next(3);
            fluxSink.next(4);
            fluxSink.complete();
        }).subscribe(CommonUtils.subscriber());
        System.out.println("After: Creating Flux with Create");


        System.out.println("Before: Creating Flux with Create with multiple items");

        Flux.create(fluxSink -> {
            String countryName;
            do{
                countryName= CommonUtils.faker().country().name();
                fluxSink.next(countryName);
            }while (!countryName.equals("Canada"));
            fluxSink.complete();
        }).subscribe(CommonUtils.subscriber());
        System.out.println("After: Creating Flux with Create with multiple items");

    }
}
