package com.dairytrack.security;

import com.dairytrack.dto.ApiResponseDto;
import com.dairytrack.dto.UnauthorizedResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        UnauthorizedResponseDto unauthorizedResponseDto = new UnauthorizedResponseDto(
                HttpServletResponse.SC_UNAUTHORIZED,
                "Unauthorized",
                request.getServletPath()
        );

        ApiResponseDto<UnauthorizedResponseDto> apiErrorResponseDto = new ApiResponseDto<>(
                "JWT token is missing or invalid", unauthorizedResponseDto
        );

        new ObjectMapper().writeValue(response.getOutputStream(), apiErrorResponseDto);
    }
}
