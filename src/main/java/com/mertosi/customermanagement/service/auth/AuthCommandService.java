package com.mertosi.customermanagement.service.auth;

import com.mertosi.customermanagement.model.dto.request.auth.AuthRequest;
import com.mertosi.customermanagement.model.dto.response.auth.AuthResponse;

public interface AuthCommandService {
    AuthResponse login(AuthRequest request);
}
