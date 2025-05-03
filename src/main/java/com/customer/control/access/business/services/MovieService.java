package com.customer.control.access.business.services;

import com.customer.control.access.domain.entities.Movie;
import com.customer.control.access.domain.repositories.IMovieRepository;
import com.customer.control.access.domain.services.IMovieService;

import java.util.List;

public class MovieService implements IMovieService {

    private final IMovieRepository movieRepository;

    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public Movie save(Movie input) {
        return movieRepository.save(input);
    }

    @Override
    public Movie update(Movie input) {
        return movieRepository.update(input);
    }

    @Override
    public Movie findById(Long id) {
        var movie = movieRepository.findById(id);
        return movie.orElse(null);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie deleteById(Long id) {
        var movie = movieRepository.findById(id);
        movieRepository.deleteById(id);
        return movie.orElse(null);
    }
}
