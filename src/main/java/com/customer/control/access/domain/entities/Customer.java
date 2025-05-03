package com.customer.control.access.domain.entities;

import com.customer.control.access.domain.entities.base.BaseEntity;
import com.customer.control.access.domain.extensions.PasswordAttributeConverterExtension;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Customer extends BaseEntity {

    private String name;
    private String email;
    @Convert(converter = PasswordAttributeConverterExtension.class)
    private String password;

}
