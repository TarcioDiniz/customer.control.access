package com.customer.control.access.application.controllers;

import com.customer.control.access.domain.common.requests.assignment.AssignmentRequest;
import com.customer.control.access.domain.dtos.AssignmentDto;
import com.customer.control.access.domain.services.IAssignmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(
        name = "Assignments",
        description = "Operações de gestão de assignments"
)
@RestController
@RequestMapping("/assignments")
public class AssignmentController {

    private final IAssignmentService assignmentService;

    public AssignmentController(IAssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<AssignmentDto> register(@RequestBody AssignmentRequest request) {
        AssignmentDto assignmentDto = this.assignmentService.save(request);
        return ResponseEntity.status(201).body(assignmentDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssignmentDto> update(@PathVariable Long id, @RequestBody AssignmentRequest request) {
        AssignmentDto assignmentDto = this.assignmentService.update(request, id);
        return ResponseEntity.ok(assignmentDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssignmentDto> findById(@PathVariable Long id) {
        AssignmentDto assignmentDto = this.assignmentService.findById(id);
        return ResponseEntity.ok(assignmentDto);
    }

    @GetMapping
    public ResponseEntity<List<AssignmentDto>> findAll() {
        List<AssignmentDto> assignmentDtos = this.assignmentService.findAll();
        return ResponseEntity.ok(assignmentDtos);
    }


    @GetMapping("/customer/{id}")
    public ResponseEntity<List<AssignmentDto>> findAllByCustomerId(@PathVariable Long id) {
        List<AssignmentDto> assignmentDtos = this.assignmentService.findALlByCustomerId(id);
        return ResponseEntity.ok(assignmentDtos);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<List<AssignmentDto>> findAllByMovieId(@PathVariable Long id) {
        List<AssignmentDto> assignmentDtos = this.assignmentService.findAllByMovieId(id);
        return ResponseEntity.ok(assignmentDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.assignmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
