package com.customer.control.access.domain.common.responses.customer;

import com.customer.control.access.domain.common.responses.base.BaseResponse;
import com.customer.control.access.domain.dtos.CustomerDto;
import lombok.Getter;

@Getter
public class CustomerResponse extends BaseResponse<CustomerDto> {

    public CustomerResponse(CustomerDto data, boolean success, String message) {
        super(data, success, message);
    }
}
