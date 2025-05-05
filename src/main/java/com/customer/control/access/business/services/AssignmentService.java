package com.customer.control.access.business.services;

import com.customer.control.access.domain.common.requests.assignment.AssignmentRequest;
import com.customer.control.access.domain.dtos.AssignmentDto;
import com.customer.control.access.domain.entities.Assignment;
import com.customer.control.access.domain.repositories.IAssignmentRepository;
import com.customer.control.access.domain.repositories.ICustomerRepository;
import com.customer.control.access.domain.repositories.IMovieRepository;
import com.customer.control.access.domain.services.IAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService implements IAssignmentService {

    private final IAssignmentRepository assignmentRepository;
    private final ICustomerRepository customerRepository;
    private final IMovieRepository movieRepository;

    public AssignmentService(IAssignmentRepository assignmentRepository, ICustomerRepository customerRepository, IMovieRepository movieRepository) {
        this.assignmentRepository = assignmentRepository;

        this.customerRepository = customerRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<AssignmentDto> findALlByCustomerId(Long id) {
        var assignments = assignmentRepository.findAllByCustomerId(id);

        assignments.forEach(assignment -> {
            assignment.setCustomer(customerRepository.findById(assignment.getCustomerId()).orElseThrow());
            assignment.setMovie(movieRepository.findById(assignment.getMovieId()).orElseThrow());
        });

        return assignments.stream().map(AssignmentDto::new).toList();
    }

    @Override
    public List<AssignmentDto> findAllByMovieId(Long id) {
        var assignments = assignmentRepository.findByMovieId(id);

        assignments.forEach(assignment -> {
            assignment.setCustomer(customerRepository.findById(assignment.getCustomerId()).orElseThrow());
            assignment.setMovie(movieRepository.findById(assignment.getMovieId()).orElseThrow());
        });

        return assignments.stream().map(AssignmentDto::new).toList();
    }


    @Override
    public AssignmentDto save(AssignmentRequest input) {
        var assignment = new Assignment();
        assignment.setCustomerId(input.getCustomerId());
        assignment.setMovieId(input.getMovieId());
        assignment.setRole(input.getRole());

        var savedAssignment = assignmentRepository.save(assignment);
        return new AssignmentDto(savedAssignment);
    }

    @Override
    public AssignmentDto update(AssignmentRequest input, Long id) {
        var assignment = assignmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Assignment not found with id " + id));
        assignment.setCustomerId(input.getCustomerId());
        assignment.setMovieId(input.getMovieId());
        assignment.setRole(input.getRole());

        var updatedAssignment = assignmentRepository.save(assignment);
        return new AssignmentDto(updatedAssignment);
    }

    @Override
    public AssignmentDto findById(Long id) {
        var assignment = assignmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Assignment not found with id " + id));

        assignment.setCustomer(customerRepository.findById(assignment.getCustomerId()).orElseThrow());
        assignment.setMovie(movieRepository.findById(assignment.getMovieId()).orElseThrow());

        return new AssignmentDto(assignment);
    }

    @Override
    public List<AssignmentDto> findAll() {
        var assignments = assignmentRepository.findAll();

        assignments.forEach(assignment -> {
            assignment.setCustomer(customerRepository.findById(assignment.getCustomerId()).orElseThrow());
            assignment.setMovie(movieRepository.findById(assignment.getMovieId()).orElseThrow());
        });

        return assignments.stream().map(AssignmentDto::new).toList();
    }

    @Override
    public AssignmentDto deleteById(Long id) {
        var assignment = assignmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Assignment not found with id " + id));
        assignmentRepository.deleteById(id);
        return new AssignmentDto(assignment);
    }
}
