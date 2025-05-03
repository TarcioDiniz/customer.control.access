package com.customer.control.access.domain.repositories;

import com.customer.control.access.domain.entities.Assignment;
import com.customer.control.access.domain.repositories.base.IBaseRepository;

import java.util.List;

public interface IAssignmentRepository extends IBaseRepository<Assignment, Long> {

    List<Assignment> findALlByCustomerId(Long id);

    public List<Assignment> findAllByMovieId(Long id);

}
