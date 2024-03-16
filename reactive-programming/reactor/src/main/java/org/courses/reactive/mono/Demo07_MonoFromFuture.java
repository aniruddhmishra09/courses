package org.courses.reactive.mono;

import org.courses.reactive.utils.CommonUtils;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class Demo07_MonoFromFuture {

    public static void main(String[] args) {

        System.out.println("Before : Using Completable Future");

        Mono.fromFuture(Demo07_MonoFromFuture.getName())
                .subscribe(CommonUtils.onNextBehaviour());

        CommonUtils.sleepThreadInSeconds(1);
        System.out.println("After : Using Completable Future");
    }

    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(() -> CommonUtils.faker().name().fullName());
    }
}
