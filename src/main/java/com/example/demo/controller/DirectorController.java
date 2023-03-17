package com.example.demo.controller;

import com.example.demo.model.Director;
import com.example.demo.model.Movie;
import com.example.demo.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @PostMapping("/director")
    public Director saveDirector(@RequestBody Director director){
        return directorService.save(director);
    }


    @DeleteMapping("/director/{id}")
    public void deleteDirector (@PathVariable Long id){
        directorService.deleteDirector(id);}
    //@GetMapping("/director/{id}/movie")
    //public ResponseEntity<List<Movie>> getMoviesByDirector(@PathVariable Long directorId) {
        //List<Movie> movies = directorService.getMovieList(directorId);
        //return new ResponseEntity<>(movies, HttpStatus.OK);
    //}
    @GetMapping("/director/{id}")
    public Optional<Director> findDirectorbyId (@PathVariable Long id) {
        return directorService.findDirectorbyId(id);
    }

    @PutMapping("/director")
    public Director updateExistingDirector(@RequestBody Director director){
        return directorService.updateExistingDirector(director);

    }
}
