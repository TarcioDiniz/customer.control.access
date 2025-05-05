package com.customer.control.access.business.services;

import com.customer.control.access.domain.common.requests.auth.LoginRequest;
import com.customer.control.access.domain.common.responses.auth.AuthResponse;
import com.customer.control.access.domain.dtos.CustomerDto;
import com.customer.control.access.domain.services.IAssignmentService;
import com.customer.control.access.domain.services.IAuthService;
import com.customer.control.access.domain.services.ICustomerService;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    private final ICustomerService customerService;
    private final IAssignmentService assignmentService;

    public AuthService(ICustomerService customerService, IAssignmentService assignmentService) {
        this.customerService = customerService;
        this.assignmentService = assignmentService;
    }

    @Override
    public AuthResponse login(LoginRequest input) {
        var customer = customerService.findByEmail(input.getEmail());


        if (customer == null) {
            throw new RuntimeException("User not found");
        }


        if (!customer.getPassword().equals(input.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }


        CustomerDto customerDto = new CustomerDto(customer, assignmentService.findALlByCustomerId(customer.getId()));


        return new AuthResponse(customerDto, true, "Login successful");
    }
}
