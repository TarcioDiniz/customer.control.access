package com.customer.control.access.domain.common.requests.movie;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

public class MovieRequest {

    private String title;
    private String description;
    private String genre;
    @Temporal(TemporalType.DATE)
    private Date releaseDate;

}
