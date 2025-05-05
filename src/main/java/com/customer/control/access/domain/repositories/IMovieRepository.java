package com.customer.control.access.domain.repositories;

import com.customer.control.access.domain.entities.Movie;
import com.customer.control.access.domain.repositories.base.IBaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMovieRepository extends IBaseRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
    List<Movie> findByTitleContainingIgnoreCase(String title);
}
