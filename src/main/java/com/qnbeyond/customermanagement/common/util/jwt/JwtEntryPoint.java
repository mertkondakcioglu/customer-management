package com.qnbeyond.customermanagement.common.util.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qnbeyond.customermanagement.model.dto.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException e) throws IOException {
        log.error("Unauthorized error: {}", e.getMessage());

        BaseResponse<?> baseResponse = BaseResponse.builder()
                .success(false)
                .errorMessage(e.getMessage())
                .build();

        String json = new ObjectMapper().writeValueAsString(baseResponse);

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(json);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.flushBuffer();
    }
}
