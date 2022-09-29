package com.qnbeyond.customermanagement.controller.auth;

import com.qnbeyond.customermanagement.model.dto.request.auth.AuthRequest;
import com.qnbeyond.customermanagement.model.dto.response.BaseResponse;
import com.qnbeyond.customermanagement.model.dto.response.auth.AuthResponse;
import com.qnbeyond.customermanagement.service.auth.AuthCommandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Api(tags = "Auth")
public class AuthController {
    private final AuthCommandService authCommandService;

    @PostMapping("/login")
    @ApiOperation(value = "Login")
    public BaseResponse<AuthResponse> login(@RequestBody @Valid AuthRequest request) {
        return BaseResponse.<AuthResponse>builder()
                .data(authCommandService.login(request))
                .build();
    }
}
