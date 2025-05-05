package com.customer.control.access.business.services;

import com.customer.control.access.domain.common.requests.movie.MovieRequest;
import com.customer.control.access.domain.entities.Movie;
import com.customer.control.access.domain.repositories.IMovieRepository;
import com.customer.control.access.domain.services.IMovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    private final IMovieRepository movieRepository;

    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public Movie save(MovieRequest input) {
        var movie = new Movie();
        movie.setTitle(input.getTitle());
        movie.setDescription(input.getDescription());
        movie.setReleaseDate(input.getReleaseDate());
        movie.setGenre(input.getGenre());
        movie.setReleaseDate(input.getReleaseDate());

        return movieRepository.save(movie);
    }

    @Override
    public Movie update(MovieRequest input, Long id) {
        return null;
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

    @Override
    public List<Movie> searchByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }
}
