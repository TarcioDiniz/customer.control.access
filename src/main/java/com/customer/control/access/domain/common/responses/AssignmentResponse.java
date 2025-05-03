package com.customer.control.access.domain.common.responses;

import com.customer.control.access.domain.common.responses.base.BaseResponse;
import com.customer.control.access.domain.dtos.AssignmentDto;
import lombok.Getter;

@Getter
public class AssignmentResponse extends BaseResponse<AssignmentDto> {

    public AssignmentResponse(AssignmentDto data, boolean success, String message) {
        super(data, success, message);
    }

}
