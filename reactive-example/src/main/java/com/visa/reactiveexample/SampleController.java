package com.visa.reactiveexample;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/hello")
public class SampleController {

    @GetMapping()
    public Flux<Integer> returnFlux() {
        return Flux.just(10, 20, 30, 40, 50, 60)
                .delayElements(Duration.ofSeconds(1)).log();
    }


    // Server Side Events
    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> returnFluxStream() {
        return Flux.just(10, 20, 30, 40, 50, 60)
                .delayElements(Duration.ofSeconds(1)).log();
    }

    @GetMapping("/mono")
    public Mono<String> monoMethod() {
        return Mono.just("Hello World");
    }
}
