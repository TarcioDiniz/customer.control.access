package com.customer.control.access.domain.repositories;

import com.customer.control.access.domain.entities.Assignment;
import com.customer.control.access.domain.repositories.base.IBaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAssignmentRepository extends IBaseRepository<Assignment, Long> {

    // Se Assignment tiver um campo "customerId" mapeado diretamente:
    List<Assignment> findAllByCustomerId(Long customerId);

    // Se Assignment tiver relacionamento ManyToOne<CustomerController> customer:
    // List<Assignment> findAllByCustomer_Id(Long customerId);

    // Se quiser usar JPQL explícito (opcional):
    @Query("SELECT a FROM Assignment a WHERE a.customerId = :customerId")
    List<Assignment> findByCustomerId(@Param("customerId") Long customerId);

    @Query("SELECT a FROM Assignment a WHERE a.movieId = :movieId")
    List<Assignment> findByMovieId(@Param("movieId") Long movieId);
}