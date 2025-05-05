package com.customer.control.access.domain.common.requests.movie;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MovieRequest {

    private String title;
    private String description;
    private String genre;
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

}
