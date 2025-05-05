package com.customer.control.access.domain.common.responses.assignment;

import com.customer.control.access.domain.common.responses.base.BaseListResponse;
import com.customer.control.access.domain.dtos.AssignmentDto;

import java.util.List;

public class AssignmentListResponse extends BaseListResponse<AssignmentDto> {
    public AssignmentListResponse(List<AssignmentDto> data, boolean success, String message) {
        super(data, success, message);
    }
}
