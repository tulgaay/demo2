package com.example.demo.service;

import com.example.demo.model.Director;
import com.example.demo.model.Movie;
import com.example.demo.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    @Autowired
    DirectorRepository directorRepository;

    public Director save(Director director) {
        return directorRepository.save(director);
    }

    public void deleteDirector(Long id) {
        directorRepository.deleteById(id);
    }

    public List<Movie> getMovieList(Long directorId) {
        Optional<Director> optionalDirector = directorRepository.findById(directorId);
        if (optionalDirector.isPresent()) {
            Director director = optionalDirector.get();
            return director.getMovieList();
        }
        return new ArrayList<>();
    }

    public Optional<Director> findDirectorbyId(Long id) {
        return directorRepository.findById(id);
    }

    public Director updateExistingDirector(Director director) {
        return directorRepository.save(director);
    }
}

