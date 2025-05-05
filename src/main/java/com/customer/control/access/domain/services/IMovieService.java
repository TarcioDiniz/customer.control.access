package com.customer.control.access.domain.services;

import com.customer.control.access.domain.common.requests.movie.MovieRequest;
import com.customer.control.access.domain.entities.Movie;
import com.customer.control.access.domain.services.base.IBaseService;

import java.util.List;

public interface IMovieService extends IBaseService<MovieRequest, Movie> {
    List<Movie> searchByTitle(String title);
}
