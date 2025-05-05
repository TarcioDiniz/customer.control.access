package com.customer.control.access;

import com.customer.control.access.business.services.AuthService;
import com.customer.control.access.domain.common.requests.auth.LoginRequest;
import com.customer.control.access.domain.common.responses.auth.AuthResponse;
import com.customer.control.access.domain.entities.Customer;
import com.customer.control.access.domain.services.IAssignmentService;
import com.customer.control.access.domain.services.ICustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {
    @Mock
    ICustomerService customerService;
    @Mock
    IAssignmentService assignmentService;
    @InjectMocks
    AuthService authService;

    @Test
    void testLoginSuccess() {
        LoginRequest request = new LoginRequest();
        request.setEmail("john@example.com");
        request.setPassword("pass");
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setEmail("john@example.com");
        customer.setPassword("pass");
        when(customerService.findByEmail("john@example.com")).thenReturn(customer);
        when(assignmentService.findALlByCustomerId(1L)).thenReturn(List.of());

        AuthResponse response = authService.login(request);

        assertTrue(response.isSuccess());
        assertEquals("Login successful", response.getMessage());
        assertEquals(1L, response.getData().getId());
    }

    @Test
    void testLoginUserNotFound() {
        LoginRequest request = new LoginRequest();
        request.setEmail("john@example.com");
        request.setPassword("pass");
        when(customerService.findByEmail("john@example.com")).thenReturn(null);

        RuntimeException ex = assertThrows(RuntimeException.class, () -> authService.login(request));
        assertEquals("User not found", ex.getMessage());
    }

    @Test
    void testLoginInvalidCredentials() {
        LoginRequest request = new LoginRequest();
        request.setEmail("john@example.com");
        request.setPassword("wrong");
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setEmail("john@example.com");
        customer.setPassword("pass");
        when(customerService.findByEmail("john@example.com")).thenReturn(customer);

        RuntimeException ex = assertThrows(RuntimeException.class, () -> authService.login(request));
        assertEquals("Invalid credentials", ex.getMessage());
    }
}