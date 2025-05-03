package com.customer.control.access.domain.dtos;

import com.customer.control.access.domain.dtos.base.BaseEntityDto;
import com.customer.control.access.domain.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDto extends BaseEntityDto {

    private String name;
    private String email;
    private Iterable<String> roles;

    public CustomerDto() {

    }

    public CustomerDto(Customer customer, List<AssignmentDto> assignments) {

        this.setId(customer.getId());
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.roles = assignments.stream().map(AssignmentDto::getRole).map(Enum::name).toList();
        this.setCreatedAt(customer.getCreatedAt());
        this.setUpdatedAt(customer.getUpdatedAt());

    }

}
