package com.customer.control.access.domain.common.requests.assignment;

import com.customer.control.access.domain.enums.AssignmentType;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AssignmentRequest {

    private Long customerId;
    private Long movieId;
    private AssignmentType role;

}
