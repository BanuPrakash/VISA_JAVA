package com.visa.reactiveexample;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class MovieController {
    private final MovieRepository movieRepository;

    @PostMapping(value = "/movie")
    public Mono<String> addMovie(@RequestBody Movie movie) {
        movieRepository.save(movie).subscribe();
        return Mono.just("Movie Added!!!"); // dump into Outbound Channel handler
    }

    @GetMapping(value = "/movie", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Movie> getMovies() {
        return  movieRepository.findBy(); // Tailable
    }

    // Browser Consumer to Controller,
    // Controller is a Consumer to MongoReact Repository and a Publisher to Client/Browser

}
