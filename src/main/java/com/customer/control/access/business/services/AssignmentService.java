package com.customer.control.access.business.services;

import com.customer.control.access.domain.dtos.AssignmentDto;
import com.customer.control.access.domain.entities.Assignment;
import com.customer.control.access.domain.repositories.IAssignmentRepository;
import com.customer.control.access.domain.services.IAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService implements IAssignmentService {

    private final IAssignmentRepository assignmentRepository;

    public AssignmentService(IAssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public List<AssignmentDto> findALlByCustomerId(Long id) {
        var assignments = assignmentRepository.findAllByCustomerId(id);
        return assignments.stream().map(AssignmentDto::new).toList();
    }

    @Override
    public List<AssignmentDto> findAllByMovieId(Long id) {
        var assignments = assignmentRepository.findByMovieId(id);
        return assignments.stream().map(AssignmentDto::new).toList();
    }

    @Override
    public AssignmentDto save(Assignment input) {
        var assignment = assignmentRepository.save(input);
        return new AssignmentDto(assignment);
    }

    @Override
    public AssignmentDto update(Assignment input) {
        var assignment = assignmentRepository.save(input);
        return new AssignmentDto(assignment);
    }

    @Override
    public AssignmentDto findById(Long id) {
        var assignment = assignmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Assignment not found with id " + id));
        return new AssignmentDto(assignment);
    }

    @Override
    public List<AssignmentDto> findAll() {
        var assignments = assignmentRepository.findAll();
        return assignments.stream().map(AssignmentDto::new).toList();
    }

    @Override
    public AssignmentDto deleteById(Long id) {
        var assignment = assignmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Assignment not found with id " + id));
        assignmentRepository.deleteById(id);
        return new AssignmentDto(assignment);
    }
}
