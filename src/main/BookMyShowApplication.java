package main;

import main.models.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class BookMyShowApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);

        Movie movie = new Movie();
        movie.setName("Harry Potter");
        movie.setActors(new ArrayList<>());
    }
}

