package com.customer.control.access.domain.services;

import com.customer.control.access.domain.common.requests.customer.CustomerRequest;
import com.customer.control.access.domain.dtos.CustomerDto;
import com.customer.control.access.domain.entities.Customer;
import com.customer.control.access.domain.services.base.IBaseService;

public interface ICustomerService extends IBaseService<CustomerRequest, CustomerDto> {

    Customer findByEmail(String email);

}
