package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie saveMovie(Movie movie) {
            return movieRepository.save(movie);

    }


    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie updateExistingMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}