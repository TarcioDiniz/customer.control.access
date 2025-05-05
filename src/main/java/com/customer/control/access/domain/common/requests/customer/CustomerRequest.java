package com.customer.control.access.domain.common.requests.customer;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {

    private String name;
    private String email;
    private String password;

}
