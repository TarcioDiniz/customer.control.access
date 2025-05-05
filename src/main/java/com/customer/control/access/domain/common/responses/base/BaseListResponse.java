package com.customer.control.access.domain.common.responses.base;

import java.util.List;

public class BaseListResponse<T> extends BaseResponse<List<T>> {
    public BaseListResponse(List<T> data, boolean success, String message) {
        super(data, success, message);
    }
}
