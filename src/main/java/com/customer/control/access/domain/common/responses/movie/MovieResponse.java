package com.customer.control.access.domain.common.responses.movie;

import com.customer.control.access.domain.common.responses.base.BaseResponse;
import com.customer.control.access.domain.entities.Movie;
import lombok.Getter;

@Getter
public class MovieResponse extends BaseResponse<Movie> {

    public MovieResponse(Movie data, boolean success, String message) {
        super(data, success, message);
    }

}
