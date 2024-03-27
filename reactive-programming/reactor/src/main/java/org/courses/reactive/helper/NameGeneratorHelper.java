package org.courses.reactive.helper;

import org.courses.reactive.utils.CommonUtils;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameGeneratorHelper {

    public static List<String> getNamesAsList(int count){
        List<String> names = new ArrayList<>(count);
        for(int ctr = 0 ; ctr<count; ctr++){
            names.add(NameGeneratorHelper.getName());
        }
        return names;
    }

    public static Flux<String> getNamesAsFlux(int count){
        return Flux.range(0 , count).map(i -> NameGeneratorHelper.getName());

    }

    private static String getName(){
        CommonUtils.sleepThreadInSeconds(1);
        return CommonUtils.faker().name().firstName();
    }
}
