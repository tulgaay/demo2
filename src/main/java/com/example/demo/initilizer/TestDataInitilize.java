package com.example.demo.initilizer;

import com.example.demo.model.Director;
import com.example.demo.model.Movie;
import com.example.demo.repository.DirectorRepository;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestDataInitilize implements CommandLineRunner {

    private MovieRepository movieRepository;

    private DirectorRepository directorRepository;

    public TestDataInitilize(MovieRepository movieRepository, DirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Movie movie1 = new Movie("Kış Uykusu", "4 hrs", "2018");
        Movie movie2 = new Movie("Mr. Fox", "2 hrs", "2020");
        Movie movie3 = new Movie("Grand Budapest Hotel", "2 hrs", "2015");

        Director director1 = new Director("NBC", "M");
        Director director2 = new Director("Wes Anderson", "M");

        movie1.setDirector(director1);
        movie2.setDirector(director2);
        movie3.setDirector(director2);

        directorRepository.save(director1);
        directorRepository.save(director2);

        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);

        System.out.println(director2.getMovieList());




    }

}
