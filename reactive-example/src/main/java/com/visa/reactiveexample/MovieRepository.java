package com.visa.reactiveexample;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

//MongoRepository similar to JpaRepository
public interface MovieRepository extends ReactiveMongoRepository<Movie, String> {
    @Tailable
    Flux<Movie> findBy(); // publish read movies from mongodb
}
