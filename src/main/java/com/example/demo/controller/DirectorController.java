package com.example.demo.controller;

import com.example.demo.model.Director;
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
    @DeleteMapping("/director")
    public void deleteDirector (@RequestBody Director director){
        directorService.deleteDirector(director);
    }
    //@GetMapping("/director/{id}/movie")
    //public ResponseEntity<List<Movie>> getMoviesByDirector(@PathVariable Long directorId) {
        //List<Movie> movies = directorService.getMovieList(directorId);
        //return new ResponseEntity<>(movies, HttpStatus.OK);
    //}
    @GetMapping("/director/{id}")
    public Optional<Director> findDirectorbyId (@PathVariable Long id) {
        return directorService.findDirectorbyId(id);
    }
}
