package com.customer.control.access.domain.entities;

import com.customer.control.access.domain.entities.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Movie extends BaseEntity {

    private String name;
    private String description;
    private String genre;
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

}
