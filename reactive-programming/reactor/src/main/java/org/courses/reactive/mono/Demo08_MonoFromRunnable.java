package org.courses.reactive.mono;

import org.courses.reactive.utils.CommonUtils;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Demo08_MonoFromRunnable {

    public static void main(String[] args) {

        System.out.println("Before : Using Mono from Runnable");

        /*Runnable is useful when there is operation does not retunr anything
         * where-as it is helpful for scenario like where use wants to notify once operation is completed*/
        Runnable runnable = () -> System.out.println("Name is printed !!");

        Mono.fromRunnable(runnable).subscribe(CommonUtils.onNextBehaviour(),
                CommonUtils.onErrorBehaviour(),
                CommonUtils.onCompleteBehaviour());

        System.out.println("After : Using Mono from Runnable");
    }


}
