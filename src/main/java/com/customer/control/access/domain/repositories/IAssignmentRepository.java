package com.customer.control.access.domain.repositories;

import com.customer.control.access.domain.entities.Assignment;
import com.customer.control.access.domain.repositories.base.IBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAssignmentRepository extends IBaseRepository<Assignment, Long> {

    List<Assignment> findAllByCustomerId(Long customerId);

    @Query("SELECT a FROM Assignment a WHERE a.customerId = :customerId")
    List<Assignment> findByCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT a FROM Assignment a WHERE a.movieId = :movieId")
    List<Assignment> findByMovieId(@Param("movieId") Long movieId);
}