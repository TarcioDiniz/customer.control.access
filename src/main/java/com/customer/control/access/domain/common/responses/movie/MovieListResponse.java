package com.customer.control.access.domain.common.responses.movie;

import com.customer.control.access.domain.common.responses.base.BaseListResponse;
import com.customer.control.access.domain.entities.Movie;
import lombok.Getter;

import java.util.List;

@Getter
public class MovieListResponse extends BaseListResponse<Movie> {

    public MovieListResponse(List<Movie> data, boolean success, String message) {
        super(data, success, message);
    }
}
