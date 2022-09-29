package com.qnbeyond.customermanagement.service.auth;

import com.qnbeyond.customermanagement.model.dto.request.auth.AuthRequest;
import com.qnbeyond.customermanagement.model.dto.response.auth.AuthResponse;

public interface AuthCommandService {
    AuthResponse login(AuthRequest request);
}
