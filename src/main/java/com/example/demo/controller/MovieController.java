package com.example.demo.controller;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @PostMapping("/movie")
    public Movie saveMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }



    @GetMapping("/movie/{id}")
    public Optional<Movie> getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }
    @DeleteMapping("/movie/{id}")
    public void deleteDirector (@PathVariable Long id){
        movieService.deleteMovie(id);}

    @PutMapping("/movie")
    public Movie updateExistingMovie(@RequestBody Movie movie){
       return movieService.updateExistingMovie(movie);

    }

}