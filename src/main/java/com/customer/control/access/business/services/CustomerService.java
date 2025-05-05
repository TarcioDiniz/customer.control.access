package com.customer.control.access.business.services;

import com.customer.control.access.domain.dtos.AssignmentDto;
import com.customer.control.access.domain.dtos.CustomerDto;
import com.customer.control.access.domain.entities.Customer;
import com.customer.control.access.domain.repositories.ICustomerRepository;
import com.customer.control.access.domain.services.IAssignmentService;
import com.customer.control.access.domain.services.ICustomerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;
    private final IAssignmentService assignmentService;

    public CustomerService(ICustomerRepository customerRepository, IAssignmentService assignmentService) {
        this.customerRepository = customerRepository;
        this.assignmentService = assignmentService;
    }

    @Override
    public CustomerDto save(Customer input) {
        var customer = customerRepository.save(input);
        var assignments = assignmentService.findALlByCustomerId(customer.getId());
        return new CustomerDto(customer, assignments);

    }

    @Override
    public CustomerDto update(Customer input) {
        var customer = customerRepository.save(input);
        var assignments = assignmentService.findALlByCustomerId(customer.getId());
        return new CustomerDto(customer, assignments);
    }

    @Override
    public CustomerDto findById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + id));

        List<AssignmentDto> assignments = assignmentService.findALlByCustomerId(id);
        return new CustomerDto(customer, assignments);
    }


    @Override
    public List<CustomerDto> findAll() {
        var customers = customerRepository.findAll();
        return customers.stream().map(customer -> {
            var assignments = assignmentService.findALlByCustomerId(customer.getId());
            return new CustomerDto(customer, assignments);
        }).toList();
    }

    @Override
    public CustomerDto deleteById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + id));

        var assignments = assignmentService.findALlByCustomerId(id);

        customerRepository.deleteById(id);

        return new CustomerDto(customer, assignments);

    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
