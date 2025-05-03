package com.customer.control.access.domain.dtos.base;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public abstract class BaseEntityDto {
    private Long id;
    private Instant createdAt;
    private Instant updatedAt;
}
