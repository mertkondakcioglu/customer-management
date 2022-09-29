package com.qnbeyond.customermanagement.service.auth;

import com.qnbeyond.customermanagement.common.mapper.CustomerResponseMapper;
import com.qnbeyond.customermanagement.common.util.jwt.JwtUtils;
import com.qnbeyond.customermanagement.model.dto.request.auth.AuthRequest;
import com.qnbeyond.customermanagement.model.dto.response.auth.AuthResponse;
import com.qnbeyond.customermanagement.model.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthCommandServiceImpl implements AuthCommandService {

    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    private final CustomerResponseMapper mapper = Mappers.getMapper(CustomerResponseMapper.class);

    @Override
    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        Customer customer = (Customer) authentication.getPrincipal();
        String token = jwtUtils.generateJwtToken(customer.getEmail());

        return AuthResponse.builder()
                .token(token)
                .customer(mapper.map(customer))
                .build();
    }
}
