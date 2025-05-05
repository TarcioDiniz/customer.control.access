package com.customer.control.access;

import com.customer.control.access.business.services.CustomerService;
import com.customer.control.access.domain.common.requests.customer.CustomerRequest;
import com.customer.control.access.domain.dtos.CustomerDto;
import com.customer.control.access.domain.entities.Customer;
import com.customer.control.access.domain.repositories.ICustomerRepository;
import com.customer.control.access.domain.services.IAssignmentService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    ICustomerRepository customerRepository;
    @Mock
    IAssignmentService assignmentService;
    @InjectMocks
    CustomerService customerService;

    @Test
    void testSave() {
        CustomerRequest request = new CustomerRequest();
        request.setName("John");
        request.setEmail("john@example.com");
        when(customerRepository.save(any())).thenAnswer(i -> { Customer c = i.getArgument(0); c.setId(1L); return c; });
        when(assignmentService.findALlByCustomerId(1L)).thenReturn(List.of());

        CustomerDto dto = customerService.save(request);

        assertEquals(1L, dto.getId());
        assertEquals("John", dto.getName());
    }

    @Test
    void testUpdateNotFound() {
        when(customerRepository.findById(1L)).thenReturn(Optional.empty());
        EntityNotFoundException ex = assertThrows(EntityNotFoundException.class, () -> customerService.update(new CustomerRequest(), 1L));
        assertTrue(ex.getMessage().contains("CustomerController not found"));
    }

    @Test
    void testFindByIdSuccess() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John");
        customer.setEmail("john@example.com");
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(assignmentService.findALlByCustomerId(1L)).thenReturn(List.of());

        CustomerDto dto = customerService.findById(1L);
        assertEquals("John", dto.getName());
    }

    @Test
    void testFindAll() {
        Customer c1 = new Customer(); c1.setId(1L);
        Customer c2 = new Customer(); c2.setId(2L);
        when(customerRepository.findAll()).thenReturn(List.of(c1, c2));
        when(assignmentService.findALlByCustomerId(anyLong())).thenReturn(List.of());

        List<CustomerDto> dtos = customerService.findAll();
        assertEquals(2, dtos.size());
    }

    @Test
    void testDeleteByIdSuccess() {
        Customer customer = new Customer(); customer.setId(1L);
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(assignmentService.findALlByCustomerId(1L)).thenReturn(List.of());

        CustomerDto dto = customerService.deleteById(1L);
        verify(customerRepository).deleteById(1L);
        assertEquals(1L, dto.getId());
    }

    @Test
    void testFindByEmail() {
        Customer customer = new Customer(); customer.setId(1L);
        when(customerRepository.findByEmail("john@example.com")).thenReturn(customer);

        Customer result = customerService.findByEmail("john@example.com");
        assertEquals(1L, result.getId());
    }
}