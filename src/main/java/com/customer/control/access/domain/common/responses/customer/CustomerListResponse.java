package com.customer.control.access.domain.common.responses.customer;

import com.customer.control.access.domain.common.responses.base.BaseListResponse;
import com.customer.control.access.domain.dtos.CustomerDto;
import lombok.Getter;

import java.util.List;

@Getter
public class CustomerListResponse extends BaseListResponse<CustomerDto> {

    public CustomerListResponse(List<CustomerDto> data, boolean success, String message) {
        super(data, success, message);
    }
}
