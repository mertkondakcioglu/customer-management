package com.mertosi.customermanagement.model.dto.response.auth;

import com.mertosi.customermanagement.model.dto.response.customer.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private CustomerResponse customer;
}
