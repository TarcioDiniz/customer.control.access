package com.customer.control.access.domain.common.responses.auth;

import com.customer.control.access.domain.common.responses.base.BaseResponse;
import com.customer.control.access.domain.dtos.CustomerDto;
import lombok.Getter;


@Getter
public class AuthResponse extends BaseResponse<CustomerDto> {

    public AuthResponse(CustomerDto data, boolean success, String message) {
        super(data, success, message);
    }
}
