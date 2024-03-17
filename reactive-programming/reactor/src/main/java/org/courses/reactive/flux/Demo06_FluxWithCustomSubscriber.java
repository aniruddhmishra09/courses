package org.courses.reactive.flux;

import org.courses.reactive.utils.CommonUtils;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicReference;

public class Demo06_FluxWithCustomSubscriber {
    public static void main(String[] args) {

        System.out.println("Initializing Atomic Reference of type Subscription");
        /*As Custom Subscriber class is created as anonymous(inner) class,
         * to access subscription object, Atomic Reference will be required */
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();

        Flux.range(1, 10)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("onSubscribe method of Custom Subscriber invoked");
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext method of Custom Subscriber invoked with value - " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError method of Custom Subscriber invoked with error message - " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete method of Custom Subscriber invoked");
                    }
                });

        CommonUtils.sleepThreadInSeconds(2);


    }
}
