package com.qnbeyond.customermanagement.model.dto.request.auth;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AuthRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
