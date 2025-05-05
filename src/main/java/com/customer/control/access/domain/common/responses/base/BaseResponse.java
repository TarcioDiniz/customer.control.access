package com.customer.control.access.domain.common.responses.base;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse<T> {
    public T data;
    public String message;
    public boolean success;

    public BaseResponse(T data, boolean success, String message) {
        this.data = data;
        this.success = success;
        this.message = message;
    }

}
