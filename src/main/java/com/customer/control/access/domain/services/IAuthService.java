package com.customer.control.access.domain.services;

import com.customer.control.access.domain.common.requests.auth.LoginRequest;
import com.customer.control.access.domain.common.responses.auth.AuthResponse;

public interface IAuthService {

    AuthResponse login(LoginRequest input);

}
