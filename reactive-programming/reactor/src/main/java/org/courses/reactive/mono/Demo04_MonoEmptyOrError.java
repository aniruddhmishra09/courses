package org.courses.reactive.mono;

import org.courses.reactive.utils.CommonUtils;
import reactor.core.publisher.Mono;

public class Demo04_MonoEmptyOrError {
    public static void main(String[] args) {

        for (int userId = 1; userId < 4; userId++) {
            System.out.println("Requesting Record for User-Id - " + userId);
            userRepository(userId).subscribe(
                    CommonUtils.onNextBehaviour(),
                    CommonUtils.onErrorBehaviour(),
                    CommonUtils.onCompleteBehaviour()
            );
        }
    }

    //Mimic Database operation
    private static Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.just(CommonUtils.faker().name().firstName());
        } else if (userId == 2) {
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException("Record Not Found"));
        }
    }
}
