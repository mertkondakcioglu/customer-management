package com.mertosi.customermanagement.common.filter;

import com.mertosi.customermanagement.common.util.jwt.JwtUtils;
import com.mertosi.customermanagement.model.entity.ApiLog;
import com.mertosi.customermanagement.service.apilog.ApiLogCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApiRequestFilter extends OncePerRequestFilter {

    private final ApiLogCommandService apiLogCommandService;
    private final JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        filterChain.doFilter(requestWrapper, responseWrapper);

        try {
            ApiLog apiLog = ApiLog.builder()
                    .request(new String(requestWrapper.getContentAsByteArray()))
                    .response(new String(responseWrapper.getContentAsByteArray()))
                    .ip(request.getRemoteAddr())
                    .uri(request.getRequestURI())
                    .userAgent(request.getHeader("User-Agent"))
                    .user(jwtUtils.getEmailFromJwtToken(request))
                    .build();

            apiLogCommandService.create(apiLog);
        } catch (Exception e) {
            log.error("Unexpected error occurred while saving api log", e);
        }

        responseWrapper.copyBodyToResponse();
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();

        return path.contains("/api/v1/auth") || request.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.toString());
    }
}
