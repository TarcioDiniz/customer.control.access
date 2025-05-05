package com.customer.control.access;

import com.customer.control.access.business.services.AssignmentService;
import com.customer.control.access.domain.common.requests.assignment.AssignmentRequest;
import com.customer.control.access.domain.dtos.AssignmentDto;
import com.customer.control.access.domain.entities.Assignment;
import com.customer.control.access.domain.entities.Customer;
import com.customer.control.access.domain.entities.Movie;
import com.customer.control.access.domain.enums.AssignmentType;
import com.customer.control.access.domain.repositories.IAssignmentRepository;
import com.customer.control.access.domain.repositories.ICustomerRepository;
import com.customer.control.access.domain.repositories.IMovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AssignmentServiceTest {
    @Mock
    IAssignmentRepository assignmentRepository;
    @Mock
    ICustomerRepository customerRepository;
    @Mock
    IMovieRepository movieRepository;
    @InjectMocks
    AssignmentService assignmentService;

    @Test
    void testFindAllByCustomerId() {
        Assignment assignment = new Assignment();
        assignment.setId(1L);
        assignment.setCustomerId(2L);
        assignment.setMovieId(3L);
        assignment.setRole(AssignmentType.ACTOR);
        when(assignmentRepository.findAllByCustomerId(2L)).thenReturn(List.of(assignment));
        Customer customer = new Customer();
        customer.setId(2L);
        customer.setName("John");
        customer.setEmail("john@example.com");
        Movie movie = new Movie();
        movie.setId(3L);
        movie.setTitle("Test");
        when(customerRepository.findById(2L)).thenReturn(Optional.of(customer));
        when(movieRepository.findById(3L)).thenReturn(Optional.of(movie));

        List<AssignmentDto> dtos = assignmentService.findALlByCustomerId(2L);

        assertEquals(1, dtos.size());
        AssignmentDto dto = dtos.getFirst();
        assertEquals(1L, dto.getId());
        assertEquals("John", dto.getCustomer().getName());
        assertEquals("Test", dto.getMovie().getTitle());
    }

    @Test
    void testSave() {
        AssignmentRequest request = new AssignmentRequest();
        request.setCustomerId(2L);
        request.setMovieId(3L);
        request.setRole(AssignmentType.ACTOR);
        Assignment saved = new Assignment();
        saved.setId(1L);
        saved.setCustomerId(2L);
        saved.setMovieId(3L);
        saved.setRole(AssignmentType.ACTOR);
        when(assignmentRepository.save(any())).thenReturn(saved);

        AssignmentDto dto = assignmentService.save(request);

        assertEquals(1L, dto.getId());
        assertEquals(AssignmentType.ACTOR, dto.getRole());
    }

    @Test
    void testUpdate() {
        AssignmentRequest request = new AssignmentRequest();
        request.setCustomerId(4L);
        request.setMovieId(5L);
        request.setRole(AssignmentType.ACTOR);
        Assignment existing = new Assignment();
        existing.setId(1L);
        existing.setCustomerId(2L);
        existing.setMovieId(3L);
        existing.setRole(AssignmentType.ACTOR);
        when(assignmentRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(assignmentRepository.save(any())).thenAnswer(i -> i.getArgument(0));

        Customer updatedCust = new Customer();
        updatedCust.setId(4L);
        updatedCust.setName("Novo Cliente");
        when(customerRepository.findById(4L)).thenReturn(Optional.of(updatedCust));

        Movie updatedMov = new Movie();
        updatedMov.setId(5L);
        updatedMov.setTitle("Novo Filme");
        when(movieRepository.findById(5L)).thenReturn(Optional.of(updatedMov));


        AssignmentDto dto = assignmentService.update(request, 1L);

        assertEquals(1L, dto.getId());
        assertEquals(4L, dto.getCustomer().getId());
        assertEquals(5L, dto.getMovie().getId());
        assertEquals(AssignmentType.ACTOR, dto.getRole());
    }

    @Test
    void testDeleteById() {
        Assignment existing = new Assignment();
        existing.setId(1L);
        existing.setCustomerId(2L);
        existing.setMovieId(3L);
        existing.setRole(AssignmentType.ACTOR);
        when(assignmentRepository.findById(1L)).thenReturn(Optional.of(existing));

        AssignmentDto dto = assignmentService.deleteById(1L);

        verify(assignmentRepository).deleteById(1L);
        assertEquals(1L, dto.getId());
    }

    @Test
    void testFindById_NotFound() {
        when(assignmentRepository.findById(1L)).thenReturn(Optional.empty());
        RuntimeException ex = assertThrows(RuntimeException.class, () -> assignmentService.findById(1L));
        assertTrue(ex.getMessage().contains("Assignment not found"));
    }
}