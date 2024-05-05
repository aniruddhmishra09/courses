package org.courses.reactive.utils;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object> {

    private String subscriberName;

    public DefaultSubscriber(String subscriberName) {
        this.subscriberName = subscriberName + " - ";
    }

    public DefaultSubscriber(){
        this.subscriberName="";
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object item) {
        System.out.println(subscriberName+"Received Item : "+item);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(subscriberName+"Error : "+throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(subscriberName+"Completed");
    }
}
