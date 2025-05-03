package com.customer.control.access.domain.services;

import com.customer.control.access.domain.dtos.AssignmentDto;
import com.customer.control.access.domain.entities.Assignment;
import com.customer.control.access.domain.services.base.IBaseService;

import java.util.List;

public interface IAssignmentService extends IBaseService<Assignment, AssignmentDto> {

    List<AssignmentDto> findALlByCustomerId(Long id);

    List<AssignmentDto> findAllByMovieId(Long id);

}
