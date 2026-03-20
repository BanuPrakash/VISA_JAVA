package com.visa.reactiveexample;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.time.Duration;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MovieClient implements CommandLineRunner {
    private  final MovieRepository movieRepository;

    @Value("classpath:movies.json")
    private Resource resource;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Movie> movies = mapper.readValue(resource.getInputStream(), new TypeReference<List<Movie>>() {
        });

        Flux.fromIterable(movies)
                .delayElements(Duration.ofSeconds(2))
                .flatMap(movieRepository::save)
                .doOnComplete(() -> System.out.println("Completed !!!"))
                .subscribe();
    }
}
