package com.qnbeyond.customermanagement.controller.auth;

import com.qnbeyond.customermanagement.common.mapper.CustomerResponseMapper;
import com.qnbeyond.customermanagement.common.util.jwt.JwtUtils;
import com.qnbeyond.customermanagement.model.dto.request.auth.AuthRequest;
import com.qnbeyond.customermanagement.model.dto.response.BaseResponse;
import com.qnbeyond.customermanagement.model.dto.response.auth.AuthResponse;
import com.qnbeyond.customermanagement.model.entity.CustomerEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    private final CustomerResponseMapper mapper = Mappers.getMapper(CustomerResponseMapper.class);

    @PostMapping("/login")
    @ApiOperation(value = "Login")
    public BaseResponse<AuthResponse> login(@RequestBody @Valid AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        CustomerEntity customerEntity = (CustomerEntity) authentication.getPrincipal();
        String token = jwtUtils.generateJwtToken(customerEntity.getEmail());

        AuthResponse authResponse = AuthResponse.builder()
                .token(token)
                .customer(mapper.map(customerEntity))
                .build();

        return BaseResponse.<AuthResponse>builder()
                .data(authResponse)
                .build();
    }
}
