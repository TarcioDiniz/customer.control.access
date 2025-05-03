package com.customer.control.access.domain.entities;

import com.customer.control.access.domain.entities.base.BaseEntity;
import com.customer.control.access.domain.enums.AssignmentType;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Assignment extends BaseEntity {

    private Long customerId;
    @Transient
    private Customer customer;
    private Long movieId;
    @Transient
    private Movie movie;
    private AssignmentType role;

}
