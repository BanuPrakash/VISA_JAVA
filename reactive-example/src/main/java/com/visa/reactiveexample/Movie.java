package com.visa.reactiveexample;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document // similar to @Entity
public class Movie {
    @Id
    private String id;
    private  String title;
    private  int year;
    private String genre;
}
