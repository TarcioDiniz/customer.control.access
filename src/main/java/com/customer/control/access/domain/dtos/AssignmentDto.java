package com.customer.control.access.domain.dtos;

import com.customer.control.access.domain.dtos.base.BaseEntityDto;
import com.customer.control.access.domain.entities.Assignment;
import com.customer.control.access.domain.entities.Customer;
import com.customer.control.access.domain.entities.Movie;
import com.customer.control.access.domain.enums.AssignmentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentDto extends BaseEntityDto {

    private Customer customer;
    private Movie movie;
    private AssignmentType role;

    public AssignmentDto() {
        super();
    }

    public AssignmentDto(Assignment assignment) {
        this.setId(assignment.getId());
        this.setUpdatedAt(assignment.getUpdatedAt());
        this.setCreatedAt(assignment.getCreatedAt());
        this.customer = assignment.getCustomer();
        this.movie = assignment.getMovie();
        this.role = assignment.getRole();
    }

}
